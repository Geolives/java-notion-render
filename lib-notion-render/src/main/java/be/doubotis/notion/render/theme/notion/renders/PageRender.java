package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.pages.Page;
import org.jsoup.nodes.Element;

public class PageRender extends BlockHeaderRender {
    public PageRender() {
        super(0);
    }

    public void renderPage(final DOMBuilder domBuilder, final RenderContext context, final Page page) {
        final Element title = domBuilder.createElement("h"+this.level, page.getId());
        title.html(((NotionRenderContext)context).renderSpan(page.getProperties().getRichTextsTitle()));
        insertIntoDocument(domBuilder, context, page.getId(), title);
    }
}
