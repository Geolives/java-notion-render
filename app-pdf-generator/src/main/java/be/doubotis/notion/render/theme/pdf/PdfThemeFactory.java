
package be.doubotis.notion.render.theme.pdf;

import be.doubotis.notion.render.theme.notion.NotionThemeFactory;
import com.geolives.entities.pages.Page;

import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author cbrasseur
 */
public class PdfThemeFactory extends NotionThemeFactory {

    public PdfThemeFactory() {

    }

    @Override
    public synchronized void printHTMLContent(PrintWriter pw, Page page)
    {
        PdfRenderContext ctx = new PdfRenderContext(page);
        ctx.render(pw);
    }
}
