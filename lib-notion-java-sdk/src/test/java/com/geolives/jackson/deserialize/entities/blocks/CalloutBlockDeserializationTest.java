package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.CalloutBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalloutBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeCalloutBlock() throws Exception {
        String json = BlockJsonBuilder.getCalloutBlock();
        CalloutBlock result = objectMapper.readValue(json, CalloutBlock.class);
        assertEquals(BlockType.CALLOUT, result.getType());
        assertInstanceOf(CalloutBlock.class, result);
        assertNotNull(result.getCallout());
    }

}