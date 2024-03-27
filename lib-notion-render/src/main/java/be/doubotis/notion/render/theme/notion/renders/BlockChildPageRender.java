package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.CalloutBlock;
import com.geolives.entities.blocks.ChildPageBlock;
import org.jsoup.nodes.Element;

public class BlockChildPageRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof ChildPageBlock) {
            ChildPageBlock childPageBlock = (ChildPageBlock) block;
            final Element div = domBuilder.createElement("div", null);
            final Element a = domBuilder.createElement("a", childPageBlock.getId());
            final Element i = domBuilder.createElement("i", null);
            a.attr("href", context.buildLinkUrl(childPageBlock.getId()));
            a.addClass("page-link");
            i.addClass("far fa-file-alt");
            a.html(i.outerHtml()+childPageBlock.getTitle());
            div.appendChild(a);
            insertIntoDocument(domBuilder, context, getParentId(childPageBlock.getParent()), div);
        }
    }
}
