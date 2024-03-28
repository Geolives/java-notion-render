package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.ColumnListBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColumnListBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeColumnListBlock() throws Exception {
        String json = BlockJsonBuilder.getColumnListBlock();
        ColumnListBlock result = objectMapper.readValue(json, ColumnListBlock.class);
        assertEquals(BlockType.COLUMN_LIST, result.getType());
        assertInstanceOf(ColumnListBlock.class, result);
    }

}