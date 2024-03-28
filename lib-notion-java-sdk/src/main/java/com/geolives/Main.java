package com.geolives;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.Block;
import com.geolives.exceptions.NotionException;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        testClient();
    }

    private static void testClient() {
        final NotionClient client = new NotionClient("secret_5kRHArWuB38uqTUCS6W8I0UxxPW1gEC8nJlNgeeAaJZ");
        try {
            System.out.println(client.retrievePage("f5517d7ec74246ba87ed0c012b34bf2f"));
//            System.out.println(client.retrievePage("7746887a-e672-4399-96b2-ea3c71990ee9"));
            System.out.println(client.retrieveBlockChildren("7746887a-e672-4399-96b2-ea3c71990ee9"));
//            System.out.println(client.retrieveBlockChildren("0d0db440-40f4-4311-b68a-c8a2fd7073d9"));
            System.out.println(client.retrieveBlock("7746887a-e672-4399-96b2-ea3c71990ee9"));
//            System.out.println(client.retrieveBlock("5f9b030b-47c2-4928-be57-331dc586ce5f"));
        } catch (NotionException e) {
            System.out.println(e);
        }
    }
}