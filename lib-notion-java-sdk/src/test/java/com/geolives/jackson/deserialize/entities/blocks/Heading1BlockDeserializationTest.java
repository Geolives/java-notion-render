package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.headings.Heading1Block;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Heading1BlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeHeading1Block() throws Exception {
        String json = BlockJsonBuilder.getHeading1Block();
        Heading1Block result = objectMapper.readValue(json, Heading1Block.class);
        assertEquals(BlockType.HEADING_1, result.getType());
        assertInstanceOf(Heading1Block.class, result);
        assertNotNull(result.getHeading1());
    }

}