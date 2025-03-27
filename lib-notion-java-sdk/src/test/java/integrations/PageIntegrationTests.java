package integrations;

import com.geolives.NotionClient;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.exceptions.NotionException;
import org.junit.jupiter.api.Test;

import static com.geolives.helpers.RichTextHelper.fromText;

public class PageIntegrationTests {

    @Test
    public void testChangePageTitle() throws NotionException {
        NotionClient client = new NotionClient(System.getProperty("NOTION_SECRET"));

        RichText[] richTexts = new RichText[] {
                fromText("This is a title changed by an integration test")
        };
        client.changes().titleForPage("c0520855026f428f936018fddaae6e66", richTexts);
    }
}
