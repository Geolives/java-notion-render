package be.doubotis.notion.render;

import com.geolives.entities.pages.Page;

import java.io.PrintWriter;

/** Interface that allows the rendering of blocks by modular way. */
public interface BlockRenderFactory {
    void printCascadingStylesheet(PrintWriter pw);
    void printHTMLContent(PrintWriter pw, Page page);
}
