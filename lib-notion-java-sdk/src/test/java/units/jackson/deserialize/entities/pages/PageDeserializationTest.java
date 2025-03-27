package units.jackson.deserialize.entities.pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.pages.Page;
import units.jackson.deserialize.entities.blocks.BlockJsonBuilder;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class PageDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeUnsupportedBlock() throws Exception {
        String json = BlockJsonBuilder.getPage();
        Page result = objectMapper.readValue(json, Page.class);
        assertInstanceOf(Page.class, result);
    }
}
