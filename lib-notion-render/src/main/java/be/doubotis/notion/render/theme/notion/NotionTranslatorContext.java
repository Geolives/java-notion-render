package be.doubotis.notion.render.theme.notion;

import be.doubotis.notion.render.theme.notion.translators.*;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.pages.BreadcrumbItem;
import com.geolives.entities.pages.Page;
import com.geolives.helpers.RichTextHelper;

import java.util.Iterator;
import java.util.Map;

public class NotionTranslatorContext {

    Map<String, String> translations;

    public NotionTranslatorContext(Map<String, String> translations) {
        this.translations = translations;
    }

    public void applyTranslation(Page page) {
        // Translate title page.
        String translation = translations.get(page.getId());
        if (translation != null) {
            RichText rt = RichTextHelper.fromText(translation);
            rt.setPlainText(translation);
            page.getProperties().getTitle().setTitle(new RichText[]{ rt });
        }

        // Translate breadcrumbs.
        if (page.getBreadcrumb() != null && !page.getBreadcrumb().isEmpty()) {
            for (BreadcrumbItem item : page.getBreadcrumb()) {
                String crumbTranslation = translations.get(item.getId());
                if (crumbTranslation != null) {
                    item.setTitle(crumbTranslation);
                }
            }
        }

        // Translate blocks.
        Iterator<Block> it = page.getChildren().iterator();
        while (it.hasNext()) {
            Block block = it.next();
            this.process(it, block);
        }
    }

    private void process(Iterator<Block> it, Block block) {
        String translation = translations.get(block.getId());
        if (translation != null && translation.isEmpty()) {
            // If a translation is empty, that means the complete block must be deleted.
            it.remove();
            return;
        }

        Translator processor = instantiateTranslator(block);
        if (processor != null) {
            processor.process(block, translations);
        }
        if (block.hasChildren()) {
            Iterator<Block> subIt = block.getChildren().iterator();
            while (subIt.hasNext()) {
                Block subBlock = subIt.next();
                this.process(subIt, subBlock);
            }
        }
    }

    protected Translator instantiateTranslator(Block block) {
        switch (block.getType()) {
            case PARAGRAPH:
                return new BlockTextTranslator();
            case BULLETED_LIST_ITEM:
                return new BlockBulletedListTranslator();
            case NUMBERED_LIST_ITEM:
                return new BlockNumberedListTranslator();
            case CALLOUT:
                return new BlockCalloutTranslator();
            case HEADING_1:
                return new BlockHeaderTranslator(1);
            case HEADING_2:
                return new BlockHeaderTranslator(2);
            case HEADING_3:
                return new BlockHeaderTranslator(3);
            case QUOTE:
                return new BlockQuoteTranslator();
            case CHILD_PAGE:
                return new BlockChildPageTranslator();
            case BOOKMARK:
                return null;
            default:
                System.out.println("Unrecognize block type : " + block.getType().getValue() + " block id : " + block.getId());
                return null;
        }
    }
}
