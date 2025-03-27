package units.entities.enums;

import com.geolives.entities.enums.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorTest {
    @Test
    void testColorValues() {
        assertEquals("default", Color.DEFAULT.getValue());
        assertEquals("blue", Color.BLUE.getValue());
        assertEquals("blue_background", Color.BLUE_BACKGROUND.getValue());
        assertEquals("brown", Color.BROWN.getValue());
        assertEquals("brown_background", Color.BROWN_BACKGROUND.getValue());
        assertEquals("gray", Color.GRAY.getValue());
        assertEquals("gray_background", Color.GRAY_BACKGROUND.getValue());
        assertEquals("green", Color.GREEN.getValue());
        assertEquals("green_background", Color.GREEN_BACKGROUND.getValue());
        assertEquals("orange", Color.ORANGE.getValue());
        assertEquals("orange_background", Color.ORANGE_BACKGROUND.getValue());
        assertEquals("pink", Color.PINK.getValue());
        assertEquals("pink_background", Color.PINK_BACKGROUND.getValue());
        assertEquals("purple", Color.PURPLE.getValue());
        assertEquals("purple_background", Color.PURPLE_BACKGROUND.getValue());
        assertEquals("red", Color.RED.getValue());
        assertEquals("red_background", Color.RED_BACKGROUND.getValue());
        assertEquals("yellow", Color.YELLOW.getValue());
        assertEquals("yellow_background", Color.YELLOW_BACKGROUND.getValue());
    }
}
