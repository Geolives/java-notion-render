package be.doubotis.notion.render.theme.notion.translators;

import com.geolives.entities.blocks.Block;

import java.util.Map;

public interface Translator {
    void process(Block block, Map<String, String> translations);
}
