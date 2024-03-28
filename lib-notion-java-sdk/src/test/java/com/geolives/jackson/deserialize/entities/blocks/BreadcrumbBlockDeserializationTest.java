package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.BreadcrumbBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BreadcrumbBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeBreadcrumbBlock() throws Exception {
        String json = BlockJsonBuilder.getBreadcrumbBlockJson();
        BreadcrumbBlock result = objectMapper.readValue(json, BreadcrumbBlock.class);
        assertEquals(BlockType.BREADCRUMB, result.getType());
    }

}