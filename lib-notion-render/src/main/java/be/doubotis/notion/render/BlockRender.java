package be.doubotis.notion.render;

import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;

public interface BlockRender {

   void render(DOMBuilder domBuilder, RenderContext context, Block block);
//    void doAfter(DOMBuilder dom, RenderContext ctx, String blockId, NotionBlock nb);
}
