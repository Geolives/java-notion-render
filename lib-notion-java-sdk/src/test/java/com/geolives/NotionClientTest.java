package com.geolives;

import com.geolives.entities.Comment;
import com.geolives.entities.NotionResponse;
import com.geolives.entities.blocks.Block;
import com.geolives.exceptions.NotionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotionClientTest {
    private static final NotionClient client = new NotionClient(System.getProperty("NOTION_SECRET"));

    @Test
    public void retrieveBlockChildren() throws NotionException {
        NotionResponse<Block> response = client.retrieveBlockChildren("7746887a-e672-4399-96b2-ea3c71990ee9");
        System.out.println(response);
    }

    @Test
    public void retrieveBlockComments() throws NotionException {
        NotionResponse<Comment> response = client.retrieveBlockComments("7746887a-e672-4399-96b2-ea3c71990ee9");
        System.out.println(response);
        for (Comment comment : response.getResults()) {
            System.out.println(comment.getRawContent());
            System.out.println();
        }
    }

    @Test
    public void insertComment() throws NotionException {
        Comment response = client.insertComment("7746887a-e672-4399-96b2-ea3c71990ee9", "Hello world!");
        System.out.println(response);
    }

}