package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.QuoteBlock;
import com.geolives.entities.blocks.richtexts.RichText;

public class BlockQuoteTranslator extends BlockBaseTranslator {
    @Override
    public void translate(Block block, String translation) {
        if(block instanceof QuoteBlock) {
            QuoteBlock quoteBlock = (QuoteBlock) block;
            RichText[] rts = parseTranslation(translation);
            quoteBlock.setRichTexts(rts);
        }
    }
}
