package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.ParagraphBlock;
import com.geolives.entities.blocks.richtexts.RichText;

public class BlockTextTranslator extends BlockBaseTranslator {

    @Override
    public void translate(Block block, String translation) {
        if(block instanceof ParagraphBlock) {
            ParagraphBlock paragraph = (ParagraphBlock) block;
            RichText[] rts = parseTranslation(translation);
            paragraph.setRichTexts(rts);
        }
    }
}
