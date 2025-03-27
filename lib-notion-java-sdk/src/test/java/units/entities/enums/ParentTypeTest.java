package units.entities.enums;

import com.geolives.entities.enums.ParentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParentTypeTest {
    @Test
    void testParentTypeValues() {
        assertEquals("database_id", ParentType.DATABASEID.getValue());
        assertEquals("page_id", ParentType.PAGE.getValue());
        assertEquals("workspace", ParentType.WORKSPACE.getValue());
        assertEquals("block_id", ParentType.BLOCK.getValue());
    }
}
