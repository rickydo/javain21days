package java21days;

import nu.xom.*;

public class RssFilter {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: java RssFilter file term");
      System.exit(-1);
    }

    // save the rss location and search term
    String rssFile = args[0];
    String term = args[1];

    try {
      // fill a tree with an RSS file's XML data
      // thefile can be local or something ont he web accessible via a url
      Builder bob = new Builder();
      Document doc = bob.build(rssFile);

      // get the file's root element (<rss>)
      Element rss = doc.getRootElement();

      // Get the element's version attribute
      Attribute rssVersion = rss.getAttribute("version");
      String version = rssVersion.getValue();

      // add the DTD for RSS. 0.91 feeds, if needed
      if ( (version.equals("0.91")) & (doc.getDocType() == null) ) {
        DocType rssDtd = new DocType("rss", "http://my.netscape.com/publish/formats/rss-0.91.dtd");
        doc.insertChild(rssDtd, 0);
      }

      // get the first (and only) <channel> element
      Element channel = rss.getFirstChildElement("channel");
      
      // get its <title> element
      Element title = channel.getFirstChildElement("title");
      Text titleText = (Text) title.getChild(0);

      // change the title to reflect the search term
      titleText.setValue(titleText.getValue() + ": Search for " + term + " articles");

      // get all of the <item> elements and loop through them
      Elements items = channel.getChildElements("item");
      for (int i = 0; i < items.size(); i++) {
        // get an <item> element
        Element item = items.get(i);

        // look for a <title> element inside it
        Element iTitle = item.getFirstChildElement("title");

        // if found, look for is contents
        if (iTitle != null) {
          Text iTitleText = (Text) iTitle.getChild(0);

          // if the search text is not found in the itme,
          // delete it from the tree
          if (!iTitleText.toString().contains(term)) {
            channel.removeChild(item);
          }
        } 
      }

      // display the results with a serializer
      Serializer output = new Serializer(System.out);
      output.setIndent(2);
      output.write(doc);
    } catch (Exception exc) {
      System.out.println("Error: " + exc.getMessage());
    }
  }
}