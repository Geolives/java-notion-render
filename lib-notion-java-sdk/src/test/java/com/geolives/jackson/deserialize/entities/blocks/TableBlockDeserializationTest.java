package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.CalloutBlock;
import com.geolives.entities.blocks.TableBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeCalloutBlock() throws Exception {
        String json = BlockJsonBuilder.getTableBlock();
        TableBlock result = objectMapper.readValue(json, TableBlock.class);
        assertEquals(BlockType.TABLE, result.getType());
        assertInstanceOf(TableBlock.class, result);
        assertNotNull(result.getTable());
    }

}