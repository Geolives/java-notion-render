package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.NumberedListItemBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberedListItemBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeNumberedListItemBlockWithoutChildren() throws Exception {
        String json = BlockJsonBuilder.getNumberedListItemBlock();
        NumberedListItemBlock result = objectMapper.readValue(json, NumberedListItemBlock.class);
        assertEquals(BlockType.NUMBERED_LIST_ITEM, result.getType());
        assertInstanceOf(NumberedListItemBlock.class, result);
        assertNotNull(result.getNumberedListItem());
    }

}