package com.geolives.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.geolives.exceptions.NotionIllegalArgumentException;

public class NotionUtils {
    private static final int DASH_ID_CLEAN_LENGTH_VALID = 32;
    public static String dashifyId(String id) throws NotionIllegalArgumentException {
        if (isValidDashId(id)) return id;

        String cleanId = id.replace("-", "");
        if (cleanId.length() != DASH_ID_CLEAN_LENGTH_VALID || !cleanId.matches("[0-9a-fA-F]+")) {
            throw new NotionIllegalArgumentException("Incorrect id format: " + id);
        }

        return new StringBuilder(cleanId)
                .insert(8, '-')
                .insert(13, '-')
                .insert(18, '-')
                .insert(23, '-')
                .toString();
    }

    public static boolean isValidDashId(String id) {
        return id.matches("[0-9a-fA-F-]{36}") && id.chars().filter(ch -> ch == '-').count() == 4;
    }

    public static ObjectMapper getNotionMapper() {
        return JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .addModule(new JavaTimeModule())
                .build();
    }
}
