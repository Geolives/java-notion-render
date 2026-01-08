package be.doubotis.notion.render.theme.notion;

import be.doubotis.notion.render.theme.notion.translators.*;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.pages.BreadcrumbItem;
import com.geolives.entities.pages.Page;
import com.geolives.helpers.RichTextHelper;

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
        page.getChildren().forEach(this::process);
    }

    private void process(Block block) {
        Translator processor = instantiateTranslator(block);
        if (processor != null) {
            processor.process(block, translations);
        }
        if (block.hasChildren()) {
            block.getChildren().forEach(this::process);
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
