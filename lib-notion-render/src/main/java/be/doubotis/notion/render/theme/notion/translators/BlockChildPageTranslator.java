package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.ChildPageBlock;

public class BlockChildPageTranslator extends BlockBaseTranslator {

    @Override
    public void translate(Block block, String translation) {
        if(block instanceof ChildPageBlock) {
            ChildPageBlock childPageBlock = (ChildPageBlock) block;
            childPageBlock.setTitle(translation);
        }
    }
}
