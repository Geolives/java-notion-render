package units.jackson.deserialize.entities.icons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.IconType;
import com.geolives.entities.files.InternalFileProperties;
import com.geolives.entities.icons.InternalFileIcon;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalFileIconDeserializationTest {

    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeInternalFileIcon() throws Exception {
        String json = "{\n" +
                "                    \"type\": \"file\",\n" +
                "                    \"file\": {\n" +
                "                        \"url\": \"https://prod-files-secure.s3.us-west-2.amazonaws.com/3783ea68-f035-45f3-be49-e649e76d02e5/b9fc3dae-91af-419a-8c5a-860c2357a86b/etoile.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45HZZMZUHI%2F20240229%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20240229T093626Z&X-Amz-Expires=3600&X-Amz-Signature=af3dc298de82150dfab4779888f44e81b6f5860ce9a949d7535c384a99318213&X-Amz-SignedHeaders=host&x-id=GetObject\",\n" +
                "                        \"expiry_time\": \"2024-02-29T10:36:26.781Z\"\n" +
                "                    }\n" +
                "                }";
        InternalFileIcon result = objectMapper.readValue(json, InternalFileIcon.class);
        assertEquals(IconType.INETRNAL_FILE, result.getType());
        assertInstanceOf(InternalFileProperties.class, result.getFile());
    }

}