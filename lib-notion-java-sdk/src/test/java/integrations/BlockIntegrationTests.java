package integrations;

import com.geolives.NotionClient;
import com.geolives.entities.blocks.richtexts.Annotation;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;
import com.geolives.entities.enums.MentionRichTextType;
import com.geolives.entities.enums.RichTextType;
import com.geolives.exceptions.NotionException;
import com.geolives.helpers.RichTextHelper;
import org.junit.jupiter.api.Test;

import static com.geolives.helpers.RichTextHelper.*;

public class BlockIntegrationTests {

    @Test
    public void testChangeTextBlock() throws NotionException {
        NotionClient client = new NotionClient(System.getProperty("NOTION_SECRET"));

        RichText[] richTexts = new RichText[] {
                fromText("This is a text changed by an integration test", true, false, false, Color.RED_BACKGROUND),
                spacer(),
                fromLink("This is a link", "https://google.com"),
                spacer(),
                fromMention("c0520855026f428f936018fddaae6e66", MentionRichTextType.PAGE)
        };
        client.changes().textForBlock(BlockType.PARAGRAPH, "5d6f32f2-b28e-4119-a1b2-e9249fc37ed3", richTexts);
    }
}
