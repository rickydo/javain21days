package java21days;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class SiteClient {
  public static void main(String args[]) {
    SiteClient client = new SiteClient();
    try {
      HashMap<String , String> resp = client.getRandomSite();
      // report the results
      if (resp.size() > 0) {
        System.out.println("URL: " + resp.get("url") + "\nTitle: " + resp.get("title") + "\nDescription: " + resp.get("description"));
      }
    } catch (IOException | XmlRpcException ioe) {
      System.out.println("Exception: " + ioe.getMessage());
    }

  }
  public HashMap getRandomSite() throws IOException, XmlRpcException {
    // create the client
    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    URL server = new URL("http://localhost:4413/");
    config.setServerURL(server);
    XmlRpcClient client = new XmlRpcClient();
    client.setConfig(config);
    // create the parameters for the request
    ArrayList params = new ArrayList();
    // send the request and get the response
    HashMap result = (HashMap) client.execute("curlie.getRandomSite", params);
    return result; 
  }
}