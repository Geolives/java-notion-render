package units.jackson.deserialize.entities.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.FileType;
import com.geolives.entities.files.ExternalFile;
import com.geolives.entities.files.InternalFile;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InternalFileDeserializationTest {

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
        InternalFile result = objectMapper.readValue(json, InternalFile.class);
        assertEquals(FileType.INTERNAL, result.getType());
        assertInstanceOf(ZonedDateTime.class, result.getExpiryTime());
    }

}