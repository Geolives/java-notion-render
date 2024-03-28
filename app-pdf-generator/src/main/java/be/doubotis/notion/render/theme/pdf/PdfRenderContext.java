
package be.doubotis.notion.render.theme.pdf;

import be.doubotis.notion.render.BlockRender;
import be.doubotis.notion.render.theme.notion.NotionRenderContext;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.pages.Page;

import java.util.Map;

/**
 *
 * @author cbrasseur
 */
public class PdfRenderContext extends NotionRenderContext {

    public PdfRenderContext(final Page page) {
        super(page);
    }

    @Override
    public String buildLinkUrl(String pageId) {
        return "#" + pageId;
    }

    @Override
    protected BlockRender instantiateRender(Block block) {
        return super.instantiateRender(block);
    }
    
}
