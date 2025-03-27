package units.jackson.deserialize.entities.blocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.TableRowBlock;
import com.geolives.entities.enums.BlockType;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableRowBlockDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeCalloutBlock() throws Exception {
        String json = BlockJsonBuilder.getTableRowBlock();
        TableRowBlock result = objectMapper.readValue(json, TableRowBlock.class);
        assertEquals(BlockType.TABLE_ROW, result.getType());
        assertInstanceOf(TableRowBlock.class, result);
        assertNotNull(result.getTableRow());
    }

}