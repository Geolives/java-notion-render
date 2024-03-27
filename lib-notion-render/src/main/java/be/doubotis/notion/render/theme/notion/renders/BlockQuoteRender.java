package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.NumberedListItemBlock;
import com.geolives.entities.blocks.QuoteBlock;
import org.jsoup.nodes.Element;

import java.util.List;

public class BlockQuoteRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof QuoteBlock) {
            QuoteBlock quoteBlock = (QuoteBlock) block;
            final Element div = domBuilder.createElement("div", quoteBlock.getId());
            div.addClass("quote");
            div.addClass("color-"+quoteBlock.getColor().getValue());
            div.html(((NotionRenderContext)context).renderSpan(quoteBlock.getRichTexts()));
            insertIntoDocument(domBuilder, context, getParentId(quoteBlock.getParent()), div);
        }
    }

//    @Override
//    public void render(DOMBuilder dom, RenderContext context, String blockId, NotionBlock nb) {
//        NotionRenderContext notionContext = (NotionRenderContext) context;
//
//        List titleEl = (List) nb.getValue().getProperties().get("title");
//
//        Element div = dom.createElement( "div", blockId);
//        div.addClass("quote");
//        div.html(notionContext.renderSpan(titleEl));
//
//        String parentId = nb.getValue().getParentId();
//        insertIntoDocument(dom, context, parentId, div);
//
//        context.flagAsRendered(blockId);
//    }
}
