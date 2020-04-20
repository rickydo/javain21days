package java21days;

import java.io.*;
import nu.xom.*;

public class DomainWriter {
  public static void main(String[] args) throws IOException {
    try {
      // create a tree from an xml document
      // specified as a command-line argument
      Builder builder = new Builder();
      File xmlFile = new File("feed2.rss");
      Document doc = builder.build(xmlFile);

      // create a comment with the current time and date
      Comment timestamp = new Comment("File created " + new java.util.Date());

      // add the comment above everything else in the document
      doc.insertChild(timestamp, 0);

      // create a file output stream to a new file
      FileOutputStream f = new FileOutputStream("feed3.rss");

      // using a serializer with indention set to 2 spaces
      // write the XML document to the file
      Serializer output = new Serializer(f, "ISO-8859-1");
      output.setIndent(2);
      output.write(doc);
    } catch (ParsingException pe) {
      System.out.println("Parsing error: " + pe.getMessage());
      System.exit(-1);
    }
  }
}