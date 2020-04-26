package m8_servlets;
import java.sql.*;

public class SQLiteJDBCQuery {

	public static void main( String args[] ) {

		   Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM usuarios;" );
		      
		      while ( rs.next() ) {
		    	  
		    	 String  email = rs.getString("email");
		    	 String  pwd = rs.getString("password");
		         String  user = rs.getString("user");
		         
		         System.out.println();
		         System.out.println( "EMAIL = " + email);
		         System.out.println( "PASSWORD = " + pwd);
		         System.out.println( "USUARIO = " + user);
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully");
	}

}
