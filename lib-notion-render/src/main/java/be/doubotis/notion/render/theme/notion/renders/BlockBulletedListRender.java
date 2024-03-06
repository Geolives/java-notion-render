package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.BulletedListItemBlock;
import org.jsoup.nodes.Element;

public class BlockBulletedListRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof BulletedListItemBlock bulletedListItemBlock) {
            final Element li = domBuilder.createElement("li", bulletedListItemBlock.getId());
            li.html(((NotionRenderContext)context).renderSpan(bulletedListItemBlock.getRichTexts()));
            li.addClass("color-"+bulletedListItemBlock.getColor().getValue());
            insertIntoDocument(domBuilder, context, getParentId(bulletedListItemBlock.getParent()), li, "ul");
        }
    }
}
