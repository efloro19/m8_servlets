
import java.sql.*;

public class SQLiteJDBC {

	public static void main( String args[] ) {
	      Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE usuarios " +
	                        "(email VARCHAR(20) PRIMARY KEY    NOT NULL," +
	                        " password         VARCHAR(20)     NOT NULL, " + 
	                        " user             VARCHAR(20)     NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      
	      System.out.println("Table created successfully");
	   }

}
