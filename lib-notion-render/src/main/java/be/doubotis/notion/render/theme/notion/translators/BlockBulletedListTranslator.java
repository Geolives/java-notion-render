package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.BulletedListItemBlock;
import com.geolives.entities.blocks.richtexts.RichText;

public class BlockBulletedListTranslator extends BlockBaseTranslator {

    @Override
    public void translate(Block block, String translation) {
        if(block instanceof BulletedListItemBlock) {
            BulletedListItemBlock bulletedListItemBlock = (BulletedListItemBlock) block;
            RichText[] rts = parseTranslation(translation);
            bulletedListItemBlock.setRichTexts(rts);
        }
    }
}
