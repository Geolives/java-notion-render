package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.BulletedListItemBlock;
import com.geolives.entities.blocks.CalloutBlock;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.Map;

public class BlockCalloutRender extends BlockBaseRender {

    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof CalloutBlock) {
            CalloutBlock calloutBlock = (CalloutBlock) block;
            final Element div = domBuilder.createElement("div", calloutBlock.getId());
            div.addClass("color-"+ calloutBlock.getColor().getValue());
            div.addClass("callout");
            final IconRender iconRender = new IconRender();
            final Element iconElement = iconRender.render(domBuilder, calloutBlock.getIcon());
            div.html(iconElement.outerHtml() + ((NotionRenderContext)context).renderSpan(calloutBlock.getRichTexts()));
            insertIntoDocument(domBuilder, context, getParentId(calloutBlock.getParent()), div);
        }
    }

//    @Override
//    public void render(DOMBuilder dom, RenderContext context, String blockId, NotionBlock nb) {
//        NotionRenderContext notionContext = (NotionRenderContext) context;
//
//        List titleEl = (List) nb.getValue().getProperties().get("title");
//        Map<String, Object> format = nb.getValue().getFormat();
//
//        Element div = dom.createElement( "div", blockId);
//        div.addClass("callout");
//
//        if (format != null) {
//            Primitive backgroundColorPrimitive = Primitive.from(format.get("block_color"));
//            String backgroundColor = backgroundColorPrimitive.getContent();
//            div.attr("style", "background-color: " + hexColorFromLabel(backgroundColor) + ";");
//        }
//
//        Element imgIcon = dom.createElement("img", null);
//        imgIcon.addClass("icon");
//        imgIcon.attr("src", "");
//
//        Element divContent = dom.createElement("div", null);
//        divContent.addClass("callout-content");
//        divContent.html(notionContext.renderSpan(titleEl));
//
//        div.appendChild(imgIcon);
//        div.appendChild(divContent);
//        dom.getDocument().appendChild(div);
//
//        context.flagAsRendered(blockId);
//    }
//
//    private String hexColorFromLabel(String labelColor) {
//        if (labelColor.equals("gray_background")) {
//            return "rgba(235, 236, 237, 0.3);";
//        } else {
//            return "";
//        }
//    }
}