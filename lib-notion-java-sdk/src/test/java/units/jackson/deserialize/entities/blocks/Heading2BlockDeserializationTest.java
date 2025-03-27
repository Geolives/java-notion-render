package units.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.headings.Heading2Block;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Heading2BlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeHeading2Block() throws Exception {
        String json = BlockJsonBuilder.getHeading2Block();
        Heading2Block result = objectMapper.readValue(json, Heading2Block.class);
        assertEquals(BlockType.HEADING_2, result.getType());
        assertInstanceOf(Heading2Block.class, result);
        assertNotNull(result.getHeading2());
    }
}