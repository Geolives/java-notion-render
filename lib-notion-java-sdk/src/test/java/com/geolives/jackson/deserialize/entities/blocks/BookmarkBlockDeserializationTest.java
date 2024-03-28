package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.BookmarkBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeBookmarkBlock() throws Exception {
        String json = BlockJsonBuilder.getBookmarkBlockJson();
        BookmarkBlock result = objectMapper.readValue(json, BookmarkBlock.class);
        assertEquals(BlockType.BOOKMARK, result.getType());
        assertNotNull(result.getBookmark());
    }

}