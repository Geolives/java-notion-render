package com.geolives.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.richtexts.RichText;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class NotionRequestBuilder {
    private static final String HEADER_NOTION_VERSION = "Notion-Version";
    private static final String NOTION_VERSION = "2022-06-28";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_AUTHORIZATION_BEARER = "Bearer ";

    private final String token;
    private final ObjectMapper serializationMapper;

    public NotionRequestBuilder(final String token) {
        this.token = token;
        this.serializationMapper = new ObjectMapper();
        serializationMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public Request buildGetRequest(final HttpUrl url) {
        return new Request.Builder()
                .url(url)
                .header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + this.token)
                .header(HEADER_NOTION_VERSION, NOTION_VERSION)
                .build();
    }

    public Request buildPostCommentRequest(final HttpUrl url, final String blockId, final String comment) {
        final RequestBody body = RequestBody.create(MediaType.parse("application/json"),
                String.format("{ \"parent\": { \"page_id\": \"%s\" },\"rich_text\": [{ \"text\": { \"content\": \"%s\" } }  ] }", blockId, comment));
        return new Request.Builder()
                .url(url)
                .post(body)
                .header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + this.token)
                .header(HEADER_NOTION_VERSION, NOTION_VERSION)
                .build();

    }

    public Request buildPatchPageTitleRequest(HttpUrl url, String pageId, RichText[] title) throws JsonProcessingException {
        String titleAsJson = this.serializationMapper.writeValueAsString(title);
        String requestJson = String.format("{ \"properties\": { \"title\": %s } }", titleAsJson);
        System.out.println(requestJson);
        final RequestBody body = RequestBody.create(MediaType.parse("application/json"),
                requestJson);
        return new Request.Builder()
                .url(url)
                .patch(body)
                .header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + this.token)
                .header(HEADER_NOTION_VERSION, NOTION_VERSION)
                .build();
    }

    public Request buildPatchBlockTextRequest(HttpUrl url, String blockType, String blockId, RichText[] texts) throws JsonProcessingException{
        String textsAsJson = this.serializationMapper.writeValueAsString(texts);
        String requestJson = String.format("{ \"" + blockType + "\": { \"rich_text\": %s } }", textsAsJson);
        final RequestBody body = RequestBody.create(MediaType.parse("application/json"),
                requestJson);
        return new Request.Builder()
                .url(url)
                .patch(body)
                .header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + this.token)
                .header(HEADER_NOTION_VERSION, NOTION_VERSION)
                .build();
    }
}
