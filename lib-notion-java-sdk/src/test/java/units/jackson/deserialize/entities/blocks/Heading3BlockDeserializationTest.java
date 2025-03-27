package units.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.headings.Heading3Block;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Heading3BlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeHeading3Block() throws Exception {
        String json = BlockJsonBuilder.getHeading3Block();
        Heading3Block result = objectMapper.readValue(json, Heading3Block.class);
        assertEquals(BlockType.HEADING_3, result.getType());
        assertInstanceOf(Heading3Block.class, result);
        assertNotNull(result.getHeading3());
    }

}