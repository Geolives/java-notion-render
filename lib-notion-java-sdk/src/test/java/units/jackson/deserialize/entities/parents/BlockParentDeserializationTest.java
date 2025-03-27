package units.jackson.deserialize.entities.parents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.parents.BlockParent;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockParentDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeBlockParent() throws Exception {
        String json = "{\n" +
                "\t\"type\": \"block_id\",\n" +
                "\t\"block_id\": \"7d50a184-5bbe-4d90-8f29-6bec57ed817b\"\n" +
                "}";
        BlockParent result = objectMapper.readValue(json, BlockParent.class);
        assertEquals("7d50a184-5bbe-4d90-8f29-6bec57ed817b", result.getBlockId());
        assertEquals(ParentType.BLOCK, result.getType());
    }
}
