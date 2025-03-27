package units.jackson.deserialize.entities.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.enums.constants.ParentTypeConstants;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParentTypeDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    static class ParentTypeWrapper {
        public ParentType type;
    }

    @Test
    void deserializeDatabase() throws Exception {
        testDeserialization(ParentTypeConstants.DATABASE, ParentType.DATABASEID);
    }

    @Test
    void deserializePage() throws Exception {
        testDeserialization(ParentTypeConstants.PAGE, ParentType.PAGE);
    }

    @Test
    void deserializeWorkspace() throws Exception {
        testDeserialization(ParentTypeConstants.WORKSPACE, ParentType.WORKSPACE);
    }

    @Test
    void deserializeBlock() throws Exception {
        testDeserialization(ParentTypeConstants.BLOCK, ParentType.BLOCK);
    }

    private void testDeserialization(String jsonValue, ParentType expectedParentType) throws Exception {
        String json = String.format("{\"type\":\"%s\"}", jsonValue);
        ParentTypeWrapper result = objectMapper.readValue(json, ParentTypeWrapper.class);
        assertEquals(expectedParentType, result.type);
    }
}
