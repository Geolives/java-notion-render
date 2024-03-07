package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.BookmarkBlock;
import org.jsoup.nodes.Element;

public class BlockBookmarkRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof BookmarkBlock bookmarkBlock) {
            final Element a = domBuilder.createElement("a", bookmarkBlock.getId());
            a.attr("href", bookmarkBlock.getUrl());
            a.text(bookmarkBlock.getUrl());
            insertIntoDocument(domBuilder, context, getParentId(bookmarkBlock.getParent()), a);

        }
    }
}
