package units.jackson.deserialize.entities.parents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.parents.*;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeBlockParent() throws Exception {
        String json = "{\n" +
                "\t\"type\": \"block_id\",\n" +
                "\t\"block_id\": \"7d50a184-5bbe-4d90-8f29-6bec57ed817b\"\n" +
                "}";
        Parent result = objectMapper.readValue(json, Parent.class);
        assertInstanceOf(BlockParent.class, result);
        assertEquals("7d50a184-5bbe-4d90-8f29-6bec57ed817b", ((BlockParent)result).getBlockId());
        assertEquals(ParentType.BLOCK, result.getType());
    }

    @Test
    void deserializeWorkspaceParent() throws Exception {
        String json = "{\n" +
                "\t\"type\": \"workspace\",\n" +
                "\t\"workspace\": true\n" +
                "}";
        Parent result = objectMapper.readValue(json, Parent.class);
        assertInstanceOf(WorkspaceParent.class, result);
        assertTrue(((WorkspaceParent)result).isRoot());
        assertEquals(ParentType.WORKSPACE, result.getType());
    }

    @Test
    void deserializePageParent() throws Exception {
        String json = "{\n" +
                "  \"type\": \"page_id\",\n" +
                "\t\"page_id\": \"59833787-2cf9-4fdf-8782-e53db20768a5\"\n" +
                "}";
        Parent result = objectMapper.readValue(json, Parent.class);
        assertInstanceOf(PageParent.class, result);
        assertEquals("59833787-2cf9-4fdf-8782-e53db20768a5", ((PageParent)result).getPageId());
        assertEquals(ParentType.PAGE, result.getType());
    }

    @Test
    void deserializeDatabaseParent() throws Exception {
        String json = "{\n" +
                "  \"type\": \"database_id\",\n" +
                "  \"database_id\": \"d9824bdc-8445-4327-be8b-5b47500af6ce\"\n" +
                "}";
        Parent result = objectMapper.readValue(json, Parent.class);
        assertInstanceOf(DatabaseParent.class, result);
        assertEquals("d9824bdc-8445-4327-be8b-5b47500af6ce", ((DatabaseParent)result).getDatabaseId());
        assertEquals(ParentType.DATABASEID, result.getType());
    }

}