package com.geolives.jackson.deserialize.entities.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.Color;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorDeserializationTest {
        private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

        static class ColorWrapper {
            public Color color;
        }

        @Test
        void deserializeDefault() throws Exception {
            testDeserialization("default", Color.DEFAULT);
        }

        @Test
        void deserializeBlue() throws Exception {
            testDeserialization("blue", Color.BLUE);
        }

        @Test
        void deserializeBlueBackground() throws Exception {
            testDeserialization("blue_background", Color.BLUE_BACKGROUND);
        }

        @Test
        void deserializeBrown() throws Exception {
            testDeserialization("brown", Color.BROWN);
        }

        @Test
        void deserializeBrownBackground() throws Exception {
            testDeserialization("brown_background", Color.BROWN_BACKGROUND);
        }

        @Test
        void deserializeGray() throws Exception {
            testDeserialization("gray", Color.GRAY);
        }

        @Test
        void deserializeGrayBackground() throws Exception {
            testDeserialization("gray_background", Color.GRAY_BACKGROUND);
        }

        @Test
        void deserializeGreen() throws Exception {
            testDeserialization("green", Color.GREEN);
        }

        @Test
        void deserializeGreenBackground() throws Exception {
            testDeserialization("green_background", Color.GREEN_BACKGROUND);
        }

        @Test
        void deserializeOrange() throws Exception {
            testDeserialization("orange", Color.ORANGE);
        }

        @Test
        void deserializeOrangeBackground() throws Exception {
            testDeserialization("orange_background", Color.ORANGE_BACKGROUND);
        }

        @Test
        void deserializePink() throws Exception {
            testDeserialization("pink", Color.PINK);
        }

        @Test
        void deserializePinkBackground() throws Exception {
            testDeserialization("pink_background", Color.PINK_BACKGROUND);
        }

        @Test
        void deserializePurple() throws Exception {
            testDeserialization("purple", Color.PURPLE);
        }

        @Test
        void deserializePurpleBackground() throws Exception {
            testDeserialization("purple_background", Color.PURPLE_BACKGROUND);
        }

        @Test
        void deserializeRed() throws Exception {
            testDeserialization("red", Color.RED);
        }

        @Test
        void deserializeRedBackground() throws Exception {
            testDeserialization("red_background", Color.RED_BACKGROUND);
        }

        @Test
        void deserializeYellow() throws Exception {
            testDeserialization("yellow", Color.YELLOW);
        }

        @Test
        void deserializeYellowBackground() throws Exception {
            testDeserialization("yellow_background", Color.YELLOW_BACKGROUND);
        }

        private void testDeserialization(String jsonValue, Color expectedColor) throws Exception {
            String json = String.format("{\"color\":\"%s\"}", jsonValue);
            ColorWrapper result = objectMapper.readValue(json, ColorWrapper.class);
            assertEquals(expectedColor, result.color);
        }
}
