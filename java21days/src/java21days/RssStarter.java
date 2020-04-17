package java21days;

import java.io.*;
import nu.xom.*;

public class RssStarter {
  public static void main(String[] args) {
    // create an <rss> element to serve as the document's root
    Element rss = new Element("rss");

    // add a version attribute to the element
    Attribute version = new Attribute("version", "2.0");
    rss.addAttribute(version);
    // create a <channel> element and make it a child of <rss>
    Element channel = new Element("channel");
    rss.appendChild(channel);
    // create the channel's title
    Element title = new Element("title");
    Text titleText = new Text("Workbench");
    title.appendChild(titleText);
    channel.appendChild(title);
    // create the channel's <link>
    Element link = new Element("link");
    Text lText = new Text("http://workbench.cadenhead.org");
    link.appendChild(lText);
    channel.appendChild(link);

    // create a new document with <rss> as the root element
    Document doc = new Document(rss);

    // save the xml document
    try (
      FileWriter fw = new FileWriter("feed.rss");
      BufferedWriter out = new BufferedWriter(fw);
    ) {
      out.write(doc.toXML());
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
    System.out.println(doc.toXML());
  }
}