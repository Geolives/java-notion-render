package breadcrumbs;

import com.geolives.entities.pages.BreadcrumbItem;
import java.io.PrintWriter;
import java.util.List;

public class BreadcrumbBuilder {

    public void printHTMLContent(PrintWriter pw, List<BreadcrumbItem> items) {

        pw.println("<div class=\"breadcrumb\"><ul>");
        for (BreadcrumbItem item : items) {
            pw.print("<li><a href=\"" + "/NotionServlet?pageid=" + item.getId() + "\">" + item.getTitle() + "</a></li>");
        }
        pw.println("</ul></div>");
    }
}

