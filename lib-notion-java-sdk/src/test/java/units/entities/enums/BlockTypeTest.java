package units.entities.enums;

import com.geolives.entities.enums.BlockType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTypeTest {

    @Test
    public void testValueOfBlockTypes() {
        assertEquals("bookmark", BlockType.BOOKMARK.getValue());
        assertEquals("breadcrumb", BlockType.BREADCRUMB.getValue());
        assertEquals("bulleted_list_item", BlockType.BULLETED_LIST_ITEM.getValue());
        assertEquals("callout", BlockType.CALLOUT.getValue());
        assertEquals("child_database", BlockType.CHILD_DATABASE.getValue());
        assertEquals("child_page", BlockType.CHILD_PAGE.getValue());
        assertEquals("column", BlockType.COLUMN.getValue());
        assertEquals("column_list", BlockType.COLUMN_LIST.getValue());
        assertEquals("divider", BlockType.DIVIDER.getValue());
        assertEquals("embed", BlockType.EMBED.getValue());
        assertEquals("equation", BlockType.EQUATION.getValue());
        assertEquals("file", BlockType.FILE.getValue());
        assertEquals("heading_1", BlockType.HEADING_1.getValue());
        assertEquals("heading_2", BlockType.HEADING_2.getValue());
        assertEquals("heading_3", BlockType.HEADING_3.getValue());
        assertEquals("image", BlockType.IMAGE.getValue());
        assertEquals("link_preview", BlockType.LINK_PREVIEW.getValue());
        assertEquals("link_to_page", BlockType.LINK_TO_PAGE.getValue());
        assertEquals("numbered_list_item", BlockType.NUMBERED_LIST_ITEM.getValue());
        assertEquals("paragraph", BlockType.PARAGRAPH.getValue());
        assertEquals("pdf", BlockType.PDF.getValue());
        assertEquals("quote", BlockType.QUOTE.getValue());
        assertEquals("synced_block", BlockType.SYNCED_BLOCK.getValue());
        assertEquals("table", BlockType.TABLE.getValue());
        assertEquals("table_of_contents", BlockType.TABLE_OF_CONTENTS.getValue());
        assertEquals("table_row", BlockType.TABLE_ROW.getValue());
        assertEquals("template", BlockType.TEMPLATE.getValue());
        assertEquals("to_do", BlockType.TO_DO.getValue());
        assertEquals("toggle", BlockType.TOGGLE.getValue());
        assertEquals("unsupported", BlockType.UNSUPPORTED.getValue());
        assertEquals("video", BlockType.VIDEO.getValue());
    }
}