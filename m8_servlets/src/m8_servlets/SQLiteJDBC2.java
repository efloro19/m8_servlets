package m8_servlets;
import java.sql.*;

public class SQLiteJDBC2 {

	public static void main( String args[] ) {
	      Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String /*sql = "INSERT INTO usuarios (email,password,user) " +
	                        "VALUES ('eric@gmail.com', 'ericFLOR21-', 'efloro');"; 
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO usuarios (email,password,user) " +
	                  "VALUES ('ivan@gmail.com', 'ivanGUAR12-', 'iguardia');";
	         stmt.executeUpdate(sql);*/

	         sql = "INSERT INTO usuarios (email,password,user) " +
	                  "VALUES ('alvaro@gmail.com', 'alvaroMOLINA21-', 'amolina');"; 
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	         
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   }
	
}
