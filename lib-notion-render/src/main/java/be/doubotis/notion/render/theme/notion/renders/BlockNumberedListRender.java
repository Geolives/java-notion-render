package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.BulletedListItemBlock;
import com.geolives.entities.blocks.NumberedListItemBlock;
import org.jsoup.nodes.Element;

import java.util.*;

public class BlockNumberedListRender extends BlockBulletedListRender {

    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof NumberedListItemBlock numberedListItemBlock) {
            final Element li = domBuilder.createElement("li", numberedListItemBlock.getId());
            li.html(((NotionRenderContext)context).renderSpan(numberedListItemBlock.getRichTexts()));
            li.addClass("color-"+numberedListItemBlock.getColor().getValue());
            insertIntoDocument(domBuilder, context, getParentId(numberedListItemBlock.getParent()), li, "ol");
        }
    }
}
