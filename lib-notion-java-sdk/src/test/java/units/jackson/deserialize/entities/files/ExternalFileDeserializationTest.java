package units.jackson.deserialize.entities.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.FileType;
import com.geolives.entities.files.ExternalFile;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalFileDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeExternalFile() throws Exception {
        String json = "{\n" +
                "  \"type\": \"external\",\n" +
                "  \"external\": {\n" +
                "    \"url\": \"https://images.unsplash.com/photo-1525310072745-f49212b5ac6d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1065&q=80\"\n" +
                "  }\n" +
                "}";
        ExternalFile result = objectMapper.readValue(json, ExternalFile.class);
        assertEquals(FileType.EXTERNAL, result.getType());
    }

}