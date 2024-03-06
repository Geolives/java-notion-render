package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.ParagraphBlock;
import org.jsoup.nodes.Element;

import java.util.List;

public class BlockTextRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof ParagraphBlock paragraph) {
            final Element p = domBuilder.createElement("p", block.getId());
            p.html(((NotionRenderContext)context).renderSpan(paragraph.getRichTexts()));
            p.addClass("color-"+ paragraph.getColor().getValue());
            insertIntoDocument(domBuilder, context, getParentId(paragraph.getParent()), p);
        }
    }
}
