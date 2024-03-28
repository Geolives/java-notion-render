package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.QuoteBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuoteBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeQuoteBlockWithoutChildren() throws Exception {
        String json = BlockJsonBuilder.getQuoteBlock();
        QuoteBlock result = objectMapper.readValue(json, QuoteBlock.class);
        assertEquals(BlockType.QUOTE, result.getType());
        assertInstanceOf(QuoteBlock.class, result);
        assertNotNull(result.getQuote());
    }
}