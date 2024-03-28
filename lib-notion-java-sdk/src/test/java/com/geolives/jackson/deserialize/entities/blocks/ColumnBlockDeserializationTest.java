package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.ColumnBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ColumnBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeColumnBlock() throws Exception {
        String json = BlockJsonBuilder.getColumnBlock();
        ColumnBlock result = objectMapper.readValue(json, com.geolives.entities.blocks.ColumnBlock.class);
        assertEquals(BlockType.COLUMN, result.getType());
        assertInstanceOf(ColumnBlock.class, result);
    }

}