package com.geolives.jackson.deserialize.entities.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.FileType;
import com.geolives.entities.enums.constants.FileTypeConstants;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTypeDeserializationTest {
        private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

        static class FileWrapper {
            public FileType type;
        }

        @Test
        void deserializeInternal() throws Exception {
            testDeserialization(FileTypeConstants.INTERNAL, FileType.INTERNAL);
        }

        @Test
        void deserializeExternal() throws Exception {
            testDeserialization(FileTypeConstants.EXTERNAL, FileType.EXTERNAL);
        }

        private void testDeserialization(String jsonValue, FileType expectedType) throws Exception {
            String json = String.format("{\"type\":\"%s\"}", jsonValue);
            FileWrapper result = objectMapper.readValue(json, FileWrapper.class);
            assertEquals(expectedType, result.type);
        }
}
