package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.CalloutBlock;
import com.geolives.entities.blocks.richtexts.RichText;

public class BlockCalloutTranslator extends BlockBaseTranslator {

    @Override
    public void translate(Block block, String translation) {
        if (block instanceof CalloutBlock) {
            CalloutBlock calloutBlock = (CalloutBlock)block;
            RichText[] rts = parseTranslation(translation);
            calloutBlock.setRichTexts(rts);
        }
    }
}
