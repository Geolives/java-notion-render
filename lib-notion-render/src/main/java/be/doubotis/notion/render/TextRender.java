package be.doubotis.notion.render;

import com.geolives.entities.blocks.richtexts.RichText;

import java.io.PrintWriter;

public interface TextRender {

    String renderText(RichText[] richTexts);
}
