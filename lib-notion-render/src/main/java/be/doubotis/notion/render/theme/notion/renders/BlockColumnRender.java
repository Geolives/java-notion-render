package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.ColumnBlock;
import com.geolives.entities.blocks.ColumnListBlock;
import org.jsoup.nodes.Element;

import java.util.Map;

public class BlockColumnRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof ColumnBlock) {
            ColumnBlock columnBlock = (ColumnBlock) block;
            final Element div = domBuilder.createElement("div", columnBlock.getId());
            div.addClass("grid-column");
            insertIntoDocument(domBuilder, context, getParentId(columnBlock.getParent()), div);
        }
    }
//    @Override
//    public void render(DOMBuilder dom, RenderContext context, String blockId, NotionBlock nb) {
//        Map<String,Object> format = nb.getValue().getFormat();
//
//        Element divColumn = dom.createElement("div", blockId);
//        divColumn.addClass("grid-column");
//
//        String parentId = extractParentId(nb);
//        Element divFlex = dom.querySelector("div#" + parentId + " div.grid-row");
//
//        // Get width percentage.
//        if (format != null) {
//            String columnRatio = (String) format.get("column_ratio");
//            String columnRatioString = (Double.parseDouble(columnRatio) * 100) + "%";
//            divColumn.attr("style", "width: " + columnRatioString + ";");
//        }
//
//        divFlex.appendChild(divColumn);
//        context.flagAsRendered(blockId);
//    }
//
//    private String extractParentId(NotionBlock nb)
//    {
//        return nb.getValue().getParentId();
//    }
}
