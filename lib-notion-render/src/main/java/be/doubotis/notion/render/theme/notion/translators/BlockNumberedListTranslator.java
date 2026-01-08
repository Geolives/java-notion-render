package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.NumberedListItemBlock;
import com.geolives.entities.blocks.richtexts.RichText;

public class BlockNumberedListTranslator extends BlockBaseTranslator {

    @Override
    public void translate(Block block, String translation) {
        if(block instanceof NumberedListItemBlock) {
            NumberedListItemBlock numberedListItemBlock = (NumberedListItemBlock) block;
            RichText[] rts = parseTranslation(translation);
            numberedListItemBlock.setRichTexts(rts);
        }
    }
}
