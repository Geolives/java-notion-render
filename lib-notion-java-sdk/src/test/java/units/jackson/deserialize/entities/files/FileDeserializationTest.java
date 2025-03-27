package units.jackson.deserialize.entities.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.FileType;
import com.geolives.entities.files.ExternalFile;
import com.geolives.entities.files.File;
import com.geolives.entities.files.InternalFile;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class FileDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeInternalFile() throws Exception {
        String json = "{\n" +
                "  \"type\": \"file\",\n" +
                "  \"file\": {\n" +
                "    \"url\": \"https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7b8b0713-dbd4-4962-b38b-955b6c49a573/My_test_image.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221024%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221024T205211Z&X-Amz-Expires=3600&X-Amz-Signature=208aa971577ff05e75e68354e8a9488697288ff3fb3879c2d599433a7625bf90&X-Amz-SignedHeaders=host&x-id=GetObject\",\n" +
                "    \"expiry_time\": \"2022-10-24T22:49:22.765Z\"\n" +
                "  }\n" +
                "}";
        File result = objectMapper.readValue(json, File.class);
        assertEquals(FileType.INTERNAL, result.getType());
        assertInstanceOf(InternalFile.class, result);
    }

    @Test
    void deserializeExternalFile() throws Exception {
        String json = "{\n" +
                "  \"type\": \"external\",\n" +
                "  \"external\": {\n" +
                "    \"url\": \"https://images.unsplash.com/photo-1525310072745-f49212b5ac6d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1065&q=80\"\n" +
                "  }\n" +
                "}";
        File result = objectMapper.readValue(json, File.class);
        assertEquals(FileType.EXTERNAL, result.getType());
        assertInstanceOf(ExternalFile.class, result);
    }

}