package java21days;

import java.sql.*;

public class CustomerReporter {
  public static void main(String[] args) {
    String data = "jdbc:derby://localhost:1527sample";
    try (
      Connection conn = DriverManager.getConnection(data, "app", "app");
      Statement st = conn.createStatement()
    ) {
      Class.forName("org.apache.derby.jdbc.ClientDriver");

      ResultSet rec = st.executeQuery("select CUSTOMER_ID, NAME, CITY, STATE " + "from APP.CUSTOMER " + "order by CUSTOMER_ID");
      while (rec.next()) {
        System.out.println("CUSTOMER_ID: " + rec.getString(1));
        System.out.println("NAME: " + rec.getString(2));
        System.out.println("CITY: " + rec.getString(3));
        System.out.println("STATE: " + rec.getString(4));
        System.out.println();
      }
      rec.close();
    } catch (SQLException s) {
      System.out.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
    } catch (Exception e) {
      System.out.println("Error: " + e.toString() + e. getMessage());
    }
  }
}