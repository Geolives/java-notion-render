package com.geolives.utils;

import com.geolives.exceptions.NotionApiException;
import com.geolives.exceptions.NotionBuildUrlException;
import okhttp3.HttpUrl;
import okhttp3.MediaType;

import java.util.Optional;

public class NotionUrlBuilder {
    private static final String BASE_URL = "https://api.notion.com";
    private static final String VERSION_URL = "v1";
    private static final MediaType MEDIATYPE_JSON = MediaType.get("application/json; charset=utf-8");
    private final String url;

    public NotionUrlBuilder() {
        this.url = String.format("%s/%s", BASE_URL, VERSION_URL);
    }

    public HttpUrl buildRetrieveBlockChildrenUrl(final String blockId, final String startCursor, final int pageSize) throws NotionBuildUrlException {
        try {
            HttpUrl.Builder httpBuilder = HttpUrl.parse(String.format("%s/blocks/%s/children", this.url, blockId)).newBuilder();
            Optional.ofNullable(startCursor)
                    .ifPresent(cursor -> httpBuilder.addQueryParameter("start_cursor", cursor));
            if(pageSize > 0) {
                httpBuilder.addQueryParameter("page_size", Integer.toString(pageSize));
            }
            return httpBuilder.build();
        } catch (Exception ex) {
            throw new NotionBuildUrlException("Failed to build retrieve block children url", ex);
        }
    }

    public HttpUrl buildRetrieveBlockUrl(final String blockId) throws NotionBuildUrlException {
        try {
            return HttpUrl.parse(String.format("%s/blocks/%s", this.url, blockId));
        } catch (IllegalArgumentException ex) {
            throw new NotionBuildUrlException("Failed to build retrieve block url", ex);
        }
    }

    public HttpUrl buildRetrievePageUrl(final String pageId) throws NotionBuildUrlException {
        try {
            return HttpUrl.get(String.format("%s/pages/%s", this.url, pageId));
        } catch (IllegalArgumentException ex) {
            throw new NotionBuildUrlException("Failed to build retrieve page url", ex);
        }
    }

    public HttpUrl buildRetrieveBlockCommentUrl(final String blockId) throws NotionBuildUrlException {
        try {
            HttpUrl.Builder httpBuilder = HttpUrl.parse(String.format("%s/comments", this.url)).newBuilder();
            httpBuilder.addQueryParameter("block_id", blockId);
            return httpBuilder.build();
        } catch (IllegalArgumentException ex) {
            throw new NotionBuildUrlException("Failed to build retrieve block comments url", ex);
        }
    }

    public HttpUrl buildInsertCommentUrl() throws NotionBuildUrlException {
        try {
            return HttpUrl.get(String.format("%s/comments", this.url));
        } catch (IllegalArgumentException ex) {
            throw new NotionBuildUrlException("Failed to build retrieve page url", ex);
        }
    }
}
