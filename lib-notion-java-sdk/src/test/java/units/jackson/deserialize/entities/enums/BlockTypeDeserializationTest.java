package units.jackson.deserialize.entities.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTypeDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    static class BlockWrapper {
        public BlockType type;
    }

    @Test
    public void deserializeBookmark() throws Exception {
        testDeserialization("bookmark", BlockType.BOOKMARK);
    }

    @Test
    public void deserializeBreadcrumb() throws Exception {
        testDeserialization("breadcrumb", BlockType.BREADCRUMB);
    }

    @Test
    public void deserializeBulletedListItem() throws Exception {
        testDeserialization("bulleted_list_item", BlockType.BULLETED_LIST_ITEM);
    }

    @Test
    public void deserializeCallout() throws Exception {
        testDeserialization("callout", BlockType.CALLOUT);
    }

    @Test
    public void deserializeChildDatabase() throws Exception {
        testDeserialization("child_database", BlockType.CHILD_DATABASE);
    }

    @Test
    public void deserializeChildPage() throws Exception {
        testDeserialization("child_page", BlockType.CHILD_PAGE);
    }

    @Test
    public void deserializeColumn() throws Exception {
        testDeserialization("column", BlockType.COLUMN);
    }

    @Test
    public void deserializeColumnList() throws Exception {
        testDeserialization("column_list", BlockType.COLUMN_LIST);
    }

    @Test
    public void deserializeDivider() throws Exception {
        testDeserialization("divider", BlockType.DIVIDER);
    }

    @Test
    public void deserializeEmbed() throws Exception {
        testDeserialization("embed", BlockType.EMBED);
    }

    @Test
    public void deserializeEquation() throws Exception {
        testDeserialization("equation", BlockType.EQUATION);
    }

    @Test
    public void deserializeFile() throws Exception {
        testDeserialization("file", BlockType.FILE);
    }

    @Test
    public void deserializeHeading1() throws Exception {
        testDeserialization("heading_1", BlockType.HEADING_1);
    }

    @Test
    public void deserializeHeading2() throws Exception {
        testDeserialization("heading_2", BlockType.HEADING_2);
    }

    @Test
    public void deserializeHeading3() throws Exception {
        testDeserialization("heading_3", BlockType.HEADING_3);
    }

    @Test
    public void deserializeImage() throws Exception {
        testDeserialization("image", BlockType.IMAGE);
    }

    @Test
    public void deserializeLinkPreview() throws Exception {
        testDeserialization("link_preview", BlockType.LINK_PREVIEW);
    }

    @Test
    public void deserializeLinkToPage() throws Exception {
        testDeserialization("link_to_page", BlockType.LINK_TO_PAGE);
    }

    @Test
    public void deserializeNumberedListItem() throws Exception {
        testDeserialization("numbered_list_item", BlockType.NUMBERED_LIST_ITEM);
    }

    @Test
    public void deserializeParagraph() throws Exception {
        testDeserialization("paragraph", BlockType.PARAGRAPH);
    }

    @Test
    public void deserializePdf() throws Exception {
        testDeserialization("pdf", BlockType.PDF);
    }

    @Test
    public void deserializeQuote() throws Exception {
        testDeserialization("quote", BlockType.QUOTE);
    }

    @Test
    public void deserializeSyncedBlock() throws Exception {
        testDeserialization("synced_block", BlockType.SYNCED_BLOCK);
    }

    @Test
    public void deserializeTable() throws Exception {
        testDeserialization("table", BlockType.TABLE);
    }

    @Test
    public void deserializeTableOfContents() throws Exception {
        testDeserialization("table_of_contents", BlockType.TABLE_OF_CONTENTS);
    }

    @Test
    public void deserializeTableRow() throws Exception {
        testDeserialization("table_row", BlockType.TABLE_ROW);
    }

    @Test
    public void deserializeTemplate() throws Exception {
        testDeserialization("template", BlockType.TEMPLATE);
    }

    @Test
    public void deserializeToDo() throws Exception {
        testDeserialization("to_do", BlockType.TO_DO);
    }

    @Test
    public void deserializeToggle() throws Exception {
        testDeserialization("toggle", BlockType.TOGGLE);
    }

    @Test
    public void deserializeUnsupported() throws Exception {
        testDeserialization("unsupported", BlockType.UNSUPPORTED);
    }

    @Test
    public void deserializeVideo() throws Exception {
        testDeserialization("video", BlockType.VIDEO);
    }

    private void testDeserialization(String jsonValue, BlockType expectedType) throws Exception {
        String json = String.format("{\"type\":\"%s\"}", jsonValue);
        BlockWrapper result= objectMapper.readValue(json, BlockWrapper.class);
        assertEquals(expectedType, result.type);
    }
}
