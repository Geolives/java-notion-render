package com.geolives;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.NotionError;
import com.geolives.entities.NotionResponse;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.pages.Page;
import com.geolives.exceptions.NotionApiException;
import com.geolives.exceptions.NotionException;
import com.geolives.utils.NotionRequestBuilder;
import com.geolives.utils.NotionUrlBuilder;
import com.geolives.utils.NotionUtils;
import com.google.common.util.concurrent.RateLimiter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

public class NotionClient {

    public static int REQUEST_COUNT = 0;
    private final static int FAIL_RETRY_COUNT = 3;
    private static final RateLimiter rateLimiter = RateLimiter.create(100.0 / 60.0);
    private final OkHttpClient httpClient;
    private final ObjectMapper mapper;

    private final NotionUrlBuilder urlBuilder;
    private final NotionRequestBuilder requestBuilder;

    public NotionClient(final String token) {
        this.httpClient = new OkHttpClient();
        this.mapper = NotionUtils.getNotionMapper();
        this.urlBuilder = new NotionUrlBuilder();
        this.requestBuilder = new NotionRequestBuilder(token);
    }

    public Page retrievePage(final String pageId) throws NotionException {
        final String validId = NotionUtils.dashifyId(pageId);
        final HttpUrl url = urlBuilder.buildRetrievePageUrl(validId);
        final Request request = requestBuilder.buildGetRequest(url);
        final String resultJson = executeRequest(request, 0);
        try {
            return this.mapper.readValue(resultJson, Page.class);
        } catch (JsonProcessingException e) {
            throw new NotionException(e);
        }
    }

    public NotionResponse retrieveBlockChildren(final String blockId, final String startCursor, final int pageSize) throws NotionException {
        final String validId = NotionUtils.dashifyId(blockId);
        final HttpUrl url = this.urlBuilder.buildRetrieveBlockChildrenUrl(validId, startCursor, pageSize);
        final Request request = requestBuilder.buildGetRequest(url);
        final String resultJson = executeRequest(request, 0);
        try {
            return this.mapper.readValue(resultJson, NotionResponse.class);
        } catch (JsonProcessingException e) {
            throw new NotionException(e);
        }
    }

    public NotionResponse retrieveBlockChildren(final String blockId, final String startCursor) throws NotionException {
        return retrieveBlockChildren(blockId, startCursor, 0);
    }

    public NotionResponse retrieveBlockChildren(final String blockId, final int pageSize) throws NotionException {
        return retrieveBlockChildren(blockId, null, pageSize);
    }

    public NotionResponse retrieveBlockChildren(final String blockId) throws NotionException {
        return retrieveBlockChildren(blockId, null, 0);
    }

    public Block retrieveBlock(final String blockId) throws NotionException {
        final String validId = NotionUtils.dashifyId(blockId);
        final HttpUrl url = urlBuilder.buildRetrieveBlockUrl(validId);
        final Request request = requestBuilder.buildGetRequest(url);
        final String resultJson = executeRequest(request, 0);
        try {
            return this.mapper.readValue(resultJson, Block.class);
        } catch (JsonProcessingException e) {
            throw new NotionException(e);
        }
    }

    private String executeRequest(final Request request, int failedRequestCount) throws NotionException {
        try (final Response response = this.httpClient.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                if (response.body() != null) {
                    NotionError error = this.mapper.readValue(response.body().string(), NotionError.class);
                    throw new NotionApiException(String.format("Failed to retrieve data.\n%s", error));
                } else {
                    throw new NotionApiException("Failed to retrieve data.");
                }
            }
        } catch (IOException e) {
            if(e instanceof SocketTimeoutException && failedRequestCount < FAIL_RETRY_COUNT) {
                return executeRequest(request, ++failedRequestCount);
            } else {
                throw new NotionApiException(e);
            }
        }
    }
}
