package be.doubotis.notion.render.theme.notion.translators;

import be.doubotis.notion.render.theme.notion.parsers.TranslationSpanParser;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;

import java.util.Map;

public abstract class BlockBaseTranslator implements Translator {

    @Override
    public void process(Block block, Map<String, String> translations) {
        String translationFound = getTranslationIfExists(block.getId(), translations);
        if (translationFound != null) {
            translate(block, translationFound, translations);
        }
    }

    public abstract void translate(Block block, String translation, Map<String, String> references);

    protected String getTranslationIfExists(String blockId, Map<String, String> translations) {
        String translationFound = translations.get(blockId);
        return translationFound;
    }

    protected RichText[] parseTranslation(String translation, Map<String, String> pageTranslations) {
        return new TranslationSpanParser(pageTranslations)
                .parse(translation);
    }
}
