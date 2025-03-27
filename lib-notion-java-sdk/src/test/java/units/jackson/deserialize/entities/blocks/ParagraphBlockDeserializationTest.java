package units.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.ParagraphBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParagraphBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeParagraphBlockWithoutChildren() throws Exception {
        String json = BlockJsonBuilder.getParagraphBlock();
        ParagraphBlock result = objectMapper.readValue(json, ParagraphBlock.class);
        assertEquals(BlockType.PARAGRAPH, result.getType());
        assertInstanceOf(ParagraphBlock.class, result);
        assertNotNull(result.getParagraph());
    }

}