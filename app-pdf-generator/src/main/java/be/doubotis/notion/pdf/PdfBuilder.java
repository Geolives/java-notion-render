package be.doubotis.notion.pdf;

import be.doubotis.notion.render.theme.pdf.PdfThemeFactory;
import be.doubotis.notion.utils.HtmlPageBuilder;
import be.doubotis.notion.utils.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.pages.Page;
import com.geolives.utils.NotionUtils;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class PdfBuilder {

    private String contents = "";
    private ArrayList<File> files;

    public PdfBuilder() {
        files = new ArrayList<>();
    }

    public void addInputFile(File inputFile) {
        files.add(inputFile);
    }

    public void build() throws IOException {

        String completeHtml = "";

        HtmlPageBuilder pageBuilder = new HtmlPageBuilder();

        PdfThemeFactory themeFactory = new PdfThemeFactory();

        for (int i = 0; i < files.size(); i++) {
            if (!files.get(i).getAbsolutePath().endsWith(".json")) continue;
            String json = IOUtils.readString(files.get(i).getAbsolutePath());

            ObjectMapper om = NotionUtils.getNotionMapper();
            Page page = om.readValue(json, Page.class);

            StringWriter swHtml = new StringWriter();
            PrintWriter pwHtml = new PrintWriter(swHtml);
            themeFactory.printHTMLContent(pwHtml, page);
            pwHtml.flush();
            String html = swHtml.toString();
            pageBuilder.addHtmlContent(html);
        }

        // Prepares a String print writer.
        StringWriter swCSS = new StringWriter();
        PrintWriter pwCSS = new PrintWriter(swCSS);
        themeFactory.printCascadingStylesheet(pwCSS);
        String stylesheetContent = swCSS.toString();
        pageBuilder.addStylesheet(stylesheetContent);

        contents = pageBuilder.getDocument().html();
    }

    public void writeToFile(File outputFile) throws IOException {

        PdfWriter pdfWriter = new PdfWriter(outputFile);

        PdfDocument pdf = new PdfDocument(pdfWriter);
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new TextFooterEventHandler(36,36,36,36));

        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri("");
        Document doc = HtmlConverter.convertToDocument(contents, pdf, properties);
        doc.close();

        System.out.println("Pdf file generated: " + outputFile.getAbsolutePath());
    }
}
