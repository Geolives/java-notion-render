package units.jackson.deserialize.entities.parents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.parents.DatabaseParent;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseParentDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeDatabaseParent() throws Exception {
        String json = "{\n" +
                "  \"type\": \"database_id\",\n" +
                "  \"database_id\": \"d9824bdc-8445-4327-be8b-5b47500af6ce\"\n" +
                "}";
        DatabaseParent result = objectMapper.readValue(json, DatabaseParent.class);
        assertEquals("d9824bdc-8445-4327-be8b-5b47500af6ce", result.getDatabaseId());
        assertEquals(ParentType.DATABASEID, result.getType());
    }
}