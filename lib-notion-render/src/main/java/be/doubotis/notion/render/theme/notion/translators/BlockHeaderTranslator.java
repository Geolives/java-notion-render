package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.headings.Heading1Block;
import com.geolives.entities.blocks.headings.Heading2Block;
import com.geolives.entities.blocks.headings.Heading3Block;
import com.geolives.entities.blocks.richtexts.RichText;

import java.util.Map;

public class BlockHeaderTranslator extends BlockBaseTranslator {
    protected int level;

    public BlockHeaderTranslator(int level) {
        this.level = level + 1;
    }

    @Override
    public void translate(Block block, String translation, Map<String, String> references) {
        if (block instanceof Heading1Block) {
            Heading1Block heading1Block = (Heading1Block)block;
            RichText[] rts = parseTranslation(translation, references);
            heading1Block.setRichText(rts);
        }
        else if (block instanceof Heading2Block) {
            Heading2Block heading1Block = (Heading2Block)block;
            RichText[] rts = parseTranslation(translation, references);
            heading1Block.setRichText(rts);
        }
        else if (block instanceof Heading3Block) {
            Heading3Block heading1Block = (Heading3Block)block;
            RichText[] rts = parseTranslation(translation, references);
            heading1Block.setRichText(rts);
        }
    }
}
