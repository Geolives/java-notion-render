package units.jackson.deserialize.entities.blocks.richtexts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.richtexts.TextRichText;
import units.jackson.deserialize.entities.blocks.BlockJsonBuilder;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextRichTextDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeTextRichTextWithoutLink() throws Exception {
        String json = BlockJsonBuilder.getTextRichTextJsonWithNullLink("Test");
        TextRichText result = objectMapper.readValue(json, TextRichText.class);
        assertEquals("Test", result.getContent());
        assertNull(result.getLinkUrl());
    }

    @Test
    void deserializeTextRichTextWithLink() throws Exception {
        String json = BlockJsonBuilder.getTextRichTextJsonWithLink("Test", "url");
        TextRichText result = objectMapper.readValue(json, TextRichText.class);
        assertEquals("Test", result.getContent());
        assertEquals("url", result.getLinkUrl());
    }

}