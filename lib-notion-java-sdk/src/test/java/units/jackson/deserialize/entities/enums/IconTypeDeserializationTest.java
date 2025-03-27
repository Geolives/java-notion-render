package units.jackson.deserialize.entities.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.IconType;
import com.geolives.entities.enums.constants.IconTypeConstants;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IconTypeDeserializationTest {
        private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

        static class IconWrapper {
            public IconType type;
        }

        @Test
        void deserializeInternalFile() throws Exception {
            testDeserialization(IconTypeConstants.INTERNAL_FILE, IconType.INETRNAL_FILE);
        }
        @Test
        void deserializeExternalFile() throws Exception {
            testDeserialization(IconTypeConstants.EXTERNAL_FILE, IconType.EXTERNAL_FILE);
        }

        @Test
        void deserializeEmoji() throws Exception {
            testDeserialization(IconTypeConstants.EMOJI, IconType.EMOJI);
        }

        private void testDeserialization(String jsonValue, IconType expectedType) throws Exception {
            String json = String.format("{\"type\":\"%s\"}", jsonValue);
            IconWrapper result = objectMapper.readValue(json, IconWrapper.class);
            assertEquals(expectedType, result.type);
        }
}
