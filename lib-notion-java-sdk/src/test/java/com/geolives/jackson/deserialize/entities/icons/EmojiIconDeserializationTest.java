package com.geolives.jackson.deserialize.entities.icons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.FileType;
import com.geolives.entities.enums.IconType;
import com.geolives.entities.files.InternalFile;
import com.geolives.entities.icons.EmojiIcon;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EmojiIconDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeEmojiIcon() throws Exception {
        String json = "{\n" +
                "  \"type\": \"emoji\",\n" +
                "  \"emoji\": \"\uD83D\uDE3B\"\n" +
                "}";
        EmojiIcon result = objectMapper.readValue(json, EmojiIcon.class);
        assertEquals(IconType.EMOJI, result.getType());
        assertNotNull(result.getEmoji());
    }

}