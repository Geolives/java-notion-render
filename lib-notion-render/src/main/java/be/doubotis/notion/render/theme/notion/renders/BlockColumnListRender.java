package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.ChildPageBlock;
import com.geolives.entities.blocks.ColumnListBlock;
import org.jsoup.nodes.Element;

public class BlockColumnListRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof ColumnListBlock) {
            ColumnListBlock columnListBlock = (ColumnListBlock) block;
            final Element div = domBuilder.createElement("div", columnListBlock.getId());
            div.addClass("grid-row");
            insertIntoDocument(domBuilder, context, getParentId(columnListBlock.getParent()), div);
        }
    }

//    @Override
//    public void render(DOMBuilder dom, RenderContext context, String blockId, NotionBlock nb) {
//        Element divRow = dom.createElement("div", blockId);
//        Element divFlex = dom.createElement("div", null);
//        divFlex.addClass("grid-row");
//        divRow.appendChild(divFlex);
//        dom.getDocument().appendChild(divRow);
//        context.flagAsRendered(blockId);
//    }
//
//    private String extractParentId(NotionBlock nb)
//    {
//        return nb.getValue().getParentId();
//    }
}
