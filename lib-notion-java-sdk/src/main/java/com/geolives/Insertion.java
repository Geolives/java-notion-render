package com.geolives;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.Comment;
import com.geolives.entities.NotionError;
import com.geolives.exceptions.NotionApiException;
import com.geolives.exceptions.NotionException;
import com.geolives.utils.NotionRequestBuilder;
import com.geolives.utils.NotionUrlBuilder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Insertion {

    private final OkHttpClient httpClient;
    private final ObjectMapper mapper;
    private final NotionUrlBuilder urlBuilder;
    private final NotionRequestBuilder requestBuilder;

    Insertion(OkHttpClient httpClient, ObjectMapper mapper, NotionUrlBuilder urlBuilder, NotionRequestBuilder requestBuilder) {
        this.httpClient = httpClient;
        this.mapper = mapper;
        this.urlBuilder = urlBuilder;
        this.requestBuilder = requestBuilder;
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

    /** Inserts a comment for a block. */
    public Comment commentForBlock(final String blockId, final String comment) throws NotionException {
        final HttpUrl url = urlBuilder.buildInsertCommentUrl();
        final Request request = requestBuilder.buildPostCommentRequest(url, blockId, comment);
        final String resultJson = executeRequest(request);
        try {
            return this.mapper.readValue(resultJson, Comment.class);
        } catch (JsonProcessingException e) {
            throw new NotionException(e);
        }
    }
}
