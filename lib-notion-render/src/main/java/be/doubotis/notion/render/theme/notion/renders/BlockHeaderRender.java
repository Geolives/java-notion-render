package be.doubotis.notion.render.theme.notion.renders;


import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;

import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.headings.Heading1Block;
import com.geolives.entities.blocks.headings.Heading2Block;
import com.geolives.entities.blocks.headings.Heading3Block;
import com.geolives.entities.enums.Color;
import org.jsoup.nodes.Element;

public class BlockHeaderRender extends BlockBaseRender {

    protected int level;

    public BlockHeaderRender(final int level) {
        this.level = level+1;
    }

    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        final String headerContent;
        if(block instanceof Heading1Block heading1Block) {
            headerContent = ((NotionRenderContext)context).renderSpan(heading1Block.getRichTexts());
            if(heading1Block.isToggleable()) {
                renderToggleableTitle(domBuilder, context, block, headerContent, heading1Block.getColor());
            } else {
                renderTitle(domBuilder, context, block, headerContent, heading1Block.getColor());
            }
        } else if(block instanceof Heading2Block heading2Block) {
            headerContent = ((NotionRenderContext)context).renderSpan(heading2Block.getRichTexts());
            if(heading2Block.isToggleable()) {
                renderToggleableTitle(domBuilder, context, block, headerContent, heading2Block.getColor());
            } else {
                renderTitle(domBuilder, context, block, headerContent, heading2Block.getColor());
            }
        } else if(block instanceof Heading3Block heading3Block) {
            headerContent = ((NotionRenderContext)context).renderSpan(heading3Block.getRichTexts());
            if(heading3Block.isToggleable()) {
                renderToggleableTitle(domBuilder, context, block, headerContent, heading3Block.getColor());
            } else {
                renderTitle(domBuilder, context, block, headerContent, heading3Block.getColor());
            }
        }
    }

    private void renderToggleableTitle(final DOMBuilder domBuilder, final RenderContext context, final Block block, final String headerContent, final Color color) {
        final Element details = domBuilder.createElement("details", block.getId());
        final Element summary = domBuilder.createElement("summary", null);
        final Element title = domBuilder.createElement("h"+this.level, null);
        title.html(headerContent);
        title.addClass("color-"+color.getValue());
        summary.appendChild(title);
        details.appendChild(summary);
        insertIntoDocument(domBuilder, context, getParentId(block.getParent()), details);
    }

    private void renderTitle(final DOMBuilder domBuilder, final RenderContext context, final Block block, final String headerContent, Color color) {
        final Element title = domBuilder.createElement("h"+this.level, block.getId());
        title.html(headerContent);
        title.addClass("color-"+color.getValue());
        insertIntoDocument(domBuilder, context, getParentId(block.getParent()), title);
    }
}
