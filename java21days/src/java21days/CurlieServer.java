package java21days;

import java.io.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.*;

public class CurlieServer {
  public static void main(String[] args) {
    try {
      startServer();
    } catch (IOException ioe) {
      System.out.println("Server error: " + ioe.getMessage());
    } catch (XmlRpcException xre) {
      System.out.println("XML-RPC error: " + xre.getMessage());
    }
  }

  public static void startServer() throws IOException, XmlRpcException {
    // create the server
    System.out.println("Staring Curlie server ...");
    WebServer server = new WebServer(4413);
    XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
    PropertyHandlerMapping phm = new PropertyHandlerMapping();

    // register the handler 
    phm.addHandler("curlie", CurlieHandlerImpl.class);
    xmlRpcServer.setHandlerMapping(phm);

    // start the server
    server.start();
    System.out.println("Accepting requests ...");
  }
}