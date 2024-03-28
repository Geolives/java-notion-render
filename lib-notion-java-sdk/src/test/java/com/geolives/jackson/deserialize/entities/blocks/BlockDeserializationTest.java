package com.geolives.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.*;
import com.geolives.entities.blocks.headings.Heading1Block;
import com.geolives.entities.blocks.headings.Heading2Block;
import com.geolives.entities.blocks.headings.Heading3Block;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlockDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeBookmarkBlock() throws Exception {
        String json = BlockJsonBuilder.getBookmarkBlockJson();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.BOOKMARK, result.getType());
        assertInstanceOf(BookmarkBlock.class, result);
    }

    @Test
    void deserializeBreadcrumbBlock() throws Exception {
        String json = BlockJsonBuilder.getBreadcrumbBlockJson();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.BREADCRUMB, result.getType());
        assertInstanceOf(BreadcrumbBlock.class, result);
    }

    @Test
    void deserializeBulletedListItemBlock() throws Exception {
        String json = BlockJsonBuilder.getBulletedListItemBlockJson();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.BULLETED_LIST_ITEM, result.getType());
        assertInstanceOf(BulletedListItemBlock.class, result);
    }

    @Test
    void deserializeChildPageBlock() throws Exception {
        String json = BlockJsonBuilder.getChildPageBlock();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.CHILD_PAGE, result.getType());
        assertInstanceOf(ChildPageBlock.class, result);
    }

    @Test
    void deserializeColumnBlock() throws Exception {
        String json = BlockJsonBuilder.getColumnBlock();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.COLUMN, result.getType());
        assertInstanceOf(ColumnBlock.class, result);
    }

    @Test
    void deserializeColumnListBlock() throws Exception {
        String json = BlockJsonBuilder.getColumnListBlock();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.COLUMN_LIST, result.getType());
        assertInstanceOf(ColumnListBlock.class, result);
    }

    @Test
    void deserializeHeading1Block() throws Exception {
        String json = BlockJsonBuilder.getHeading1Block();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.HEADING_1, result.getType());
        assertInstanceOf(Heading1Block.class, result);
    }

    @Test
    void deserializeHeading2Block() throws Exception {
        String json = BlockJsonBuilder.getHeading2Block();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.HEADING_2, result.getType());
        assertInstanceOf(Heading2Block.class, result);
    }

    @Test
    void deserializeHeading3Block() throws Exception {
        String json = BlockJsonBuilder.getHeading3Block();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.HEADING_3, result.getType());
        assertInstanceOf(Heading3Block.class, result);
    }

    @Test
    void deserializeImageBlock() throws Exception {
        String json = BlockJsonBuilder.getInternalImageBlock();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.IMAGE, result.getType());
        assertInstanceOf(ImageBlock.class, result);
    }

    @Test
    void deserializeNumberedListItemBlock() throws Exception {
        String json = BlockJsonBuilder.getNumberedListItemBlock();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.NUMBERED_LIST_ITEM, result.getType());
        assertInstanceOf(NumberedListItemBlock.class, result);
    }

    @Test
    void deserializeParagraphBlock() throws Exception {
        String json = BlockJsonBuilder.getParagraphBlock();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.PARAGRAPH, result.getType());
        assertInstanceOf(ParagraphBlock.class, result);
    }

    @Test
    void deserializeQuoteBlock() throws Exception {
        String json = BlockJsonBuilder.getQuoteBlock();
        Block result = objectMapper.readValue(json, Block.class);
        assertEquals(BlockType.QUOTE, result.getType());
        assertInstanceOf(QuoteBlock.class, result);
    }
    @Test
    void deserializeUnsupportedBlock() throws Exception {
        String json = BlockJsonBuilder.getUnsupportedBlock();
        UnsupportedBlock result = objectMapper.readValue(json, UnsupportedBlock.class);
        assertEquals(BlockType.UNSUPPORTED, result.getType());
        assertInstanceOf(UnsupportedBlock.class, result);
    }

}
