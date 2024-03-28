# java-notion-render
 Rendering framework for Notion

This project serves as a modulable rendering engine for Notion Block objects (https://www.notion.so/).

To get this to work, you'll need resources files, in form of JSON files, extracted from the public Notion API.

This project comes with :
* A sample web app that serves files from the web app resources folder.
* A console app that get files from an input folder and output a Pdf file.

## Installation
The ```lib-notion-render``` is available on Maven : https://panel.repsy.io/mvn/doubotis/default/

Install with Maven :
```
<dependency>
  <groupId>be.doubotis.notion</groupId>
  <artifactId>notion-render</artifactId>
  <version>1.5</version>
</dependency>
```

Install with Gradle :
```
implementation 'be.doubotis.notion:lib-notion-render:1.13-java11'
```

## Basic usage

First, we need to retreive a `Page` based on a JSON file.

```
File f = new File("<Your filepath>" + pageId.replace("-", "") + ".json");
ObjectMapper om = NotionUtils.getNotionMapper();
Page page = om.readValue(f, Page.class);
Map<String, Block> blocks = page.getChildrenMap();
```

Then, we can ask for a rendering of the blocks into a PrintWriter.
```
PrintWriter pw;

// Render the blocks.
BlockRenderFactory factory = new NotionThemeFactory();
factory.printHTMLContent(pw, page);
```

### Console App to output Pdf file
Command line parameters :
```
-d <input directory> -o <output file>
```

## Advanced usage

You can also rewrite the theme factories to include your own behavior, CSS classes, etc.
For this, you have to create a subclass of the `NotionThemeFactory` class. In some cases, you'll want to implement `RenderContext` interface also.
Please see the `be.doubotis.notion.render.theme.notion` package for more information.

## Known caveats

Some well-known caveats :
* Datatables are not managed
* Tabs are not managed
* Some types of blocks are not managed. They are ignored in this case.
