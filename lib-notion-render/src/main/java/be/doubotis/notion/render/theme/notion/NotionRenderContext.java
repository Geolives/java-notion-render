package be.doubotis.notion.render.theme.notion;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.theme.notion.renders.*;
import be.doubotis.notion.render.BlockRender;
import be.doubotis.notion.render.BlockRenderFactory;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.pages.Page;

import java.io.PrintWriter;
import java.util.*;

public class NotionRenderContext implements RenderContext {

    private DOMBuilder domBuilder;
    private Map<BlockType, BlockRender> renders;
    private SpanRender spanRender;
    private Page page;

    public NotionRenderContext(final Page page) {
        this.domBuilder = new DOMBuilder();
        this.renders = new HashMap<>();
        this.spanRender = new SpanRender(this);
        this.page = page;
    }

    @Override
    public List<Block> getBlocks() {
        return this.page.getChildren();
    }

    @Override
    public String getPageID() {
        return this.page.getId();
    }

    @Override
    public String buildLinkUrl(final String pageId) {
        return "/NotionServlet?pageid=" + pageId;
    }

    public void render(final PrintWriter pw) {

        this.domBuilder.clear();

        final PageRender pageRender = new PageRender();
        pageRender.renderPage(this.domBuilder, this, this.page);

        for(final Block block : this.page.getChildren()) {
            doRender(block);
        }

        // Process is complete, write into the printwriter.
        this.domBuilder.writeTo(pw);
    }

    public void doRender(final Block block) {
        System.out.println("Render block : " + block.getId());
        BlockRender render = getRender(block);
        if (render != null) {
            render.render(this.domBuilder, this, block);
        }
        for (final Block child : block.getChildren()) {
            doRender(child);
        }
    }

//    public void doAfter(DOMBuilder dom, String blockId, NotionBlock nb) {
//        BlockRender render = getRender(blockId, nb);
//        if (render != null) {
//            render.doAfter(dom, this, blockId, nb);
//        }
//    }

    public synchronized BlockRender getRender(Block block) {
        final BlockType blockType = block.getType();
        BlockRender br = this.renders.get(blockType);
        if (br == null) {
            br = instantiateRender(block);
            if (br != null) {
                this.renders.put(blockType, br);
            }
        }

        return br;
    }

    protected BlockRender instantiateRender(Block block)
    {
        return switch (block.getType()) {
            case PARAGRAPH -> new BlockTextRender();
            case BULLETED_LIST_ITEM -> new BlockBulletedListRender();
            case NUMBERED_LIST_ITEM -> new BlockNumberedListRender();
            case CALLOUT -> new BlockCalloutRender();
            case HEADING_1 -> new BlockHeaderRender(1);
            case HEADING_2 -> new BlockHeaderRender(2);
            case HEADING_3 -> new BlockHeaderRender(3);
            case QUOTE -> new BlockQuoteRender();
            case IMAGE -> new BlockImageRender();
            case COLUMN_LIST -> new BlockColumnListRender();
            case COLUMN -> new BlockColumnRender();
            case CHILD_PAGE -> new BlockChildPageRender();
            case BOOKMARK -> new BlockBookmarkRender();
            default -> {
                System.out.println("Unrecognize block type : " + block.getType().getValue()+ " block id : "+ block.getId());
                yield null;
            }
        };
    }

    public String renderSpan(RichText[] richTexts) {
        return this.spanRender.renderText(richTexts);
    }
}
