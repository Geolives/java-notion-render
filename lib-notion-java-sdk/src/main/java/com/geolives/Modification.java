package com.geolives;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.NotionError;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.exceptions.NotionApiException;
import com.geolives.exceptions.NotionException;
import com.geolives.utils.NotionRequestBuilder;
import com.geolives.utils.NotionUrlBuilder;
import com.geolives.utils.NotionUtils;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Modification {

    private final OkHttpClient httpClient;
    private final ObjectMapper mapper;
    private final ObjectMapper serializationMapper;
    private final NotionUrlBuilder urlBuilder;
    private final NotionRequestBuilder requestBuilder;

    Modification(OkHttpClient httpClient, ObjectMapper mapper, NotionUrlBuilder urlBuilder, NotionRequestBuilder requestBuilder) {
        this.httpClient = httpClient;
        this.mapper = mapper;
        this.urlBuilder = urlBuilder;
        this.requestBuilder = requestBuilder;
        this.serializationMapper = new ObjectMapper();
    }

    private String executeRequest(final Request request) throws NotionException {
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
            throw new NotionApiException(e);
        }
    }

    /** Changes the title of a page. */
    public void titleForPage(String pageId, RichText[] title) throws NotionException{
        try {
            final String validId = NotionUtils.dashifyId(pageId);
            final HttpUrl url = urlBuilder.buildRetrievePageUrl(validId);
            final Request request = requestBuilder.buildPatchPageTitleRequest(url, validId, title);
            executeRequest(request);
        }
        catch (JsonProcessingException e) {
            throw new NotionException(e);
        }
    }

    /** Changes the text for a block. */
    public void textForBlock(BlockType blockType, String blockId, RichText[] texts) throws NotionException {
        try {
            final String validId = NotionUtils.dashifyId(blockId);
            final HttpUrl url = urlBuilder.buildRetrieveBlockUrl(validId);
            final Request request = requestBuilder.buildPatchBlockTextRequest(url, blockType.getValue(), validId, texts);
            executeRequest(request);
        }
        catch (JsonProcessingException e) {
            throw new NotionException(e);
        }
    }
}
