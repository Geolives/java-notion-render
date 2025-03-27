package units.utils;

import com.geolives.utils.NotionUtils;
import com.geolives.exceptions.NotionIllegalArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotionUtilsTest {

    @Test
    public void testValidIdWithFourDashes() {
        String validIdWithDashes = "12345678-90ab-cdef-1234-567890abcdef";
        try {
            assertEquals(validIdWithDashes, NotionUtils.dashifyId(validIdWithDashes));
        } catch (NotionIllegalArgumentException e) {
            fail("Test fail with exception : " + e.getMessage(), e);
        }
    }

    @Test
    public void testValidIdWithoutDashes()  {
        String validIdWithoutDashes = "1234567890abcdef1234567890abcdef";
        String expected = "12345678-90ab-cdef-1234-567890abcdef";
        try {
            assertEquals(expected, NotionUtils.dashifyId(validIdWithoutDashes));
        } catch (NotionIllegalArgumentException e) {
            fail("Test fail with exception : " + e.getMessage(), e);
        }
    }

    @Test
    public void testInvalidIdWithOneDashAndValidChars() {
        String invalidIdWithOneDash = "1234-67890abcdef1234567890abcdef";
        assertThrows(NotionIllegalArgumentException.class, () -> NotionUtils.dashifyId(invalidIdWithOneDash));
    }

    @Test
    public void testInvalidIdWithTwoDashesAndValidChars() {
        String invalidIdWithTwoDashes = "1234-6789-0abcdef1234567890abcdef";
        assertThrows(NotionIllegalArgumentException.class, () -> NotionUtils.dashifyId(invalidIdWithTwoDashes));
    }

    @Test
    public void testInvalidIdWithThreeDashesAndValidChars() {
        String invalidIdWithThreeDashes = "1234-6789-0abc-def1234567890abcdef";
        assertThrows(NotionIllegalArgumentException.class, () -> NotionUtils.dashifyId(invalidIdWithThreeDashes));
    }

    @Test
    public void testInvalidIdWithFourDashesAndNonValidChars() {
        String invalidIdWithFourDashesNonValidChars = "1234-6789-0abc-def1-234g567890abcdef";
        assertThrows(NotionIllegalArgumentException.class, () -> NotionUtils.dashifyId(invalidIdWithFourDashesNonValidChars));
    }

    @Test
    public void testInvalidIdWithoutDashesAndNonValidChars() {
        String invalidIdWithoutDashesNonValidChars = "1234567890abcdef1234567890abcdeg";
        assertThrows(NotionIllegalArgumentException.class, () -> NotionUtils.dashifyId(invalidIdWithoutDashesNonValidChars));
    }
}