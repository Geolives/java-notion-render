package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.ImageBlock;
import org.jsoup.nodes.Element;

import java.net.URLEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BlockImageRender extends BlockBaseRender {
    @Override
    public void render(DOMBuilder domBuilder, RenderContext context, Block block) {
        if(block instanceof ImageBlock imageBlock) {
            final String parentId = getParentId(imageBlock.getParent());
            final Element img = domBuilder.createElement("img", imageBlock.getId());
            img.addClass("responsive");
            img.attr("src", buildNotionMediaServletUrl(parentId, imageBlock.getId()));
            insertIntoDocument(domBuilder, context, parentId, img);
        }
    }

//    @Override
//    public void render(DOMBuilder dom, RenderContext context, String blockId, NotionBlock nb) {
//        List sourceEl = (List) nb.getValue().getProperties().get("source");
//        Map<String, Object> format = nb.getValue().getFormat();
//
//        if (sourceEl != null) {
//            List sourceComponentEl = (List) sourceEl.get(0);
//            Primitive sourcePrimitive = Primitive.from(sourceComponentEl.get(0));
//            System.out.println("Source: " + sourcePrimitive.getContent());
//            String imgSrc = buildFinalImageSrc(sourcePrimitive.getContent(), blockId);
//
//            Element img = dom.createElement("img", blockId);
//            img.addClass("responsive");
//            img.attr("src", imgSrc);
//
//            // If we got a format, we need to apply it to the img tag.
//            if (format != null) {
//                String styleString = generateStyleFromFormat(format);
//                img.attr("style", styleString);
//            }
//
//            String parentId = nb.getValue().getParentId();
//            insertIntoDocument(dom, context, parentId, img);
//        }
//
//
//        context.flagAsRendered(blockId);
//    }
//
    public String buildNonSecuredNotionStorageUrl(final String securedUrl, final String blockId) {
        String[] parts = securedUrl.split("/");
        String mediaId = parts[4];
        String fileNameWithExtension = parts[5].split("\\?")[0];

        String internalUrl = String.format("https://%s/secure.notion-static.com/%s/%s",
                parts[2].replace("prod-files-secure.", ""), mediaId, fileNameWithExtension);

        String encodedInternalUrl = URLEncoder.encode(internalUrl, UTF_8);

        String newUrl = String.format("https://www.notion.so/image/%s?table=block&id=%s", encodedInternalUrl, blockId);

        return newUrl;
    }

    public String buildNotionMediaServletUrl(final String pageId, final String blockId) {
        return String.format("/NotionMediaServlet/%s/%s", pageId, blockId);
    }
//
//    private String generateStyleFromFormat(Map<String,Object> format)
//    {
//        StringBuilder sb = new StringBuilder();
//
//        Primitive blockWithPrimitive = Primitive.from(format.get("block_width"));
//        if (blockWithPrimitive != null) {
//            String blockWidthString = Integer.parseInt(blockWithPrimitive.getContent()) + "px";
//            sb.append("width: " + blockWidthString + ";");
//        }
//
//        //TODO: Manage these properties as well.
//        //block_aspect_ratio: 0.75
//        //block_full_width: false
//        //block_height: 320
//        //block_page_width: false
//        //block_preserve_scale: true
//
//        return sb.toString();
//    }
}
