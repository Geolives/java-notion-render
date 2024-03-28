package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.BulletedListItemBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BulletedListItemBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeBulletedListItemBlockWithoutChildren() throws Exception {
        String json = BlockJsonBuilder.getBulletedListItemBlockJson();
        BulletedListItemBlock result = objectMapper.readValue(json, BulletedListItemBlock.class);
        assertEquals(BlockType.BULLETED_LIST_ITEM, result.getType());
        assertNotNull(result.getBulletedListItem());
    }

}