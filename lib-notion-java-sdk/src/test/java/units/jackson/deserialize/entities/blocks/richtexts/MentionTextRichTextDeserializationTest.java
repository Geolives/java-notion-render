package units.jackson.deserialize.entities.blocks.richtexts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.richtexts.MentionRichText;
import com.geolives.entities.enums.MentionRichTextType;
import com.geolives.entities.enums.RichTextType;
import units.jackson.deserialize.entities.blocks.BlockJsonBuilder;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MentionTextRichTextDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializePageMentionRichTextWithoutLink() throws Exception {
        String json = BlockJsonBuilder.getPageMentionRichText();
        MentionRichText result = objectMapper.readValue(json, MentionRichText.class);
        assertEquals(RichTextType.MENTION, result.getType());
        assertEquals(MentionRichTextType.PAGE, result.getMention().getType());
    }

}