package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.ChildPageBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChildPageBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeChildPageBlock() throws Exception {
        String json = BlockJsonBuilder.getChildPageBlock();
        ChildPageBlock result = objectMapper.readValue(json, ChildPageBlock.class);
        assertEquals(BlockType.CHILD_PAGE, result.getType());
        assertNotNull(result.getChildPage());
        assertNotNull(result.getTitle());
    }

}