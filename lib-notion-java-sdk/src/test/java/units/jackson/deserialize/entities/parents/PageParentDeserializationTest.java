package units.jackson.deserialize.entities.parents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.parents.DatabaseParent;
import com.geolives.entities.parents.PageParent;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageParentDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializePageParent() throws Exception {
        String json = "{\n" +
                "  \"type\": \"page_id\",\n" +
                "\t\"page_id\": \"59833787-2cf9-4fdf-8782-e53db20768a5\"\n" +
                "}";
        PageParent result = objectMapper.readValue(json, PageParent.class);
        assertEquals("59833787-2cf9-4fdf-8782-e53db20768a5", result.getPageId());
        assertEquals(ParentType.PAGE, result.getType());
    }

}