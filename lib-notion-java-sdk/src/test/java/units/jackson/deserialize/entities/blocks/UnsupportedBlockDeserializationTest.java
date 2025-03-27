package units.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.UnsupportedBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnsupportedBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeUnsupportedBlock() throws Exception {
        String json = BlockJsonBuilder.getUnsupportedBlock();
        UnsupportedBlock result = objectMapper.readValue(json, UnsupportedBlock.class);
        assertEquals(BlockType.UNSUPPORTED, result.getType());
        assertInstanceOf(UnsupportedBlock.class, result);
    }

}