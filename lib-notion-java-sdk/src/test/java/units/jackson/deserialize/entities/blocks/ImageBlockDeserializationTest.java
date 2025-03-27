package units.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.ImageBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeImageBlockWithInternalFile() throws Exception {
        String json = BlockJsonBuilder.getInternalImageBlock();
        ImageBlock result = objectMapper.readValue(json, ImageBlock.class);
        assertEquals(BlockType.IMAGE, result.getType());
        assertInstanceOf(ImageBlock.class, result);
        assertNotNull(result.getImageUrl());
        assertNotNull(result.getImage());
    }

    @Test
    void deserializeImageBlockWithExternalFile() throws Exception {
        String json = BlockJsonBuilder.getExternalImageBlock();
        ImageBlock result = objectMapper.readValue(json, ImageBlock.class);
        assertEquals(BlockType.IMAGE, result.getType());
        assertInstanceOf(ImageBlock.class, result);
        assertNotNull(result.getImageUrl());
        assertNotNull(result.getImage());
    }

}