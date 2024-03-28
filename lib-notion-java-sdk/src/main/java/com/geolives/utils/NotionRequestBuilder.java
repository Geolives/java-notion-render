package com.geolives.utils;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class NotionRequestBuilder {
    private static final String HEADER_NOTION_VERSION = "Notion-Version";
    private static final String NOTION_VERSION = "2022-06-28";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_AUTHORIZATION_BEARER = "Bearer ";

    private final String token;

    public NotionRequestBuilder(final String token) {
        this.token = token;
    }

    public Request buildGetRequest(HttpUrl url) {
        return new Request.Builder()
                .url(url)
                .header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + this.token)
                .header(HEADER_NOTION_VERSION, NOTION_VERSION)
                .build();
    }
}
