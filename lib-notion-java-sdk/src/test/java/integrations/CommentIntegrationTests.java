package integrations;

import com.geolives.NotionClient;
import com.geolives.exceptions.NotionException;
import org.junit.jupiter.api.Test;

public class CommentIntegrationTests {

    @Test
    void testInsertComment() throws NotionException {
        NotionClient client = new NotionClient(System.getProperty("NOTION_SECRET"));
        client.inserts().commentForBlock("", "This is a comment added by an integration test");
    }
}
