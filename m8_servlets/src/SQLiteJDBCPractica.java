
import java.sql.*;

public class SQLiteJDBCPractica {

	public boolean setUsuario(String mail, String passwd, String user) {
	      Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully 1");

	         
	         
	         
	         
	         
	         try {
		         stmt = c.createStatement();
		         String sql = "INSERT INTO usuarios (email,password,user) " +
	             				 "VALUES ('" + mail + "', '" + passwd + "', '" + user + "');"; 
				 stmt.executeUpdate(sql);
	
		         /*String sql = "INSERT INTO USUARIO (email,password,user) " +
		                        "VALUES ('eric@gmail.com', 'ericFLOR21-', 'efloro');"; 
		         stmt.executeUpdate(sql);*/
		         stmt.close();
		         c.commit();
		         c.close();
		         
		         return true;
		     
	         } catch ( Exception e ) {
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 try {
	    	         Class.forName("org.sqlite.JDBC");
	    	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    	         System.out.println("Opened database successfully 2");

	    	         stmt = c.createStatement();
	    	         String sql = "CREATE TABLE usuarios " +
	    	                        "(email VARCHAR(20) PRIMARY KEY    NOT NULL," +
	    	                        " password         VARCHAR(20)     NOT NULL, " + 
	    	                        " user             VARCHAR(20)     NOT NULL)"; 
	    	         stmt.executeUpdate(sql);
	    	         stmt.close();
	    	         c.close();
	    	         
	        	 
	        	   System.out.println("Table created successfully");
	    		   
	    		   Class.forName("org.sqlite.JDBC");
		  	       c = DriverManager.getConnection("jdbc:sqlite:test.db");
		  	       c.setAutoCommit(false);
		  	       System.out.println("Opened database successfully 3");
		  	       
		  	       stmt = c.createStatement();
		           sql = "INSERT INTO usuarios (email,password,user) " +
	             				 "VALUES ('" + mail + "', '" + passwd + "', '" + user + "');"; 
				   stmt.executeUpdate(sql);
	
		           /*String sql = "INSERT INTO USUARIO (email,password,user) " +
		                          "VALUES ('eric@gmail.com', 'ericFLOR21-', 'efloro');"; 
		           stmt.executeUpdate(sql);*/
		           stmt.close();
		           c.commit();
		           c.close();
		         
		         	return true;
		         	
	    		 } catch ( Exception a ) {
	    	     }
		    		   
		      }
	         
	         
	         
	         
	         
	         
	         
	         
	      } catch ( Exception e ) {
	         return false;
	      }
	      
	      return true;
	      
	      //System.out.println("Records created successfully");
	      
	}
	
	
	public boolean existeUsuario(String mail, String passwd) {
		   Connection c = null;
		   Statement stmt = null;
		   boolean existe = false;
		   int resultado = 0;
		   
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT count(*) as existe FROM usuarios where email='" + mail + "' and password='" + passwd + "';" );
		      
		      while ( rs.next() ) {
		    	  
		    	 resultado = rs.getInt("existe");
		         /*String  user = rs.getString("user");
		         
		         System.out.println();
		         System.out.println( "EMAIL = " + email);
		         System.out.println( "PASSWORD = " + pwd);
		         System.out.println( "USUARIO = " + user);
		         System.out.println();*/
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		      
		      
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   
		   System.out.println("Operation done successfully");
		   
		   if (resultado == 1) {
			   existe = true;
		   }
		   
		   return existe;
	}
	
	
	
	
	
	public boolean pedidoCurso1(String productos, String pago, String email, String grade, int cantidad) throws ClassNotFoundException, SQLException {
		boolean confirmacion = false;
		
		if(usuarioValido(email)) {
			creaTablas();
			
			Connection c = null;
		    Statement stmt = null;
			
			Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully 1");
			
			try {
		         stmt = c.createStatement();
		         String sql = "INSERT INTO cursospost (email,products,payment,grade,amount) " +
	             				 "VALUES ('" + email + "', '" + productos + "', '" + pago + "', " + grade + ", " + cantidad + ");"; 
				 stmt.executeUpdate(sql);
	
				 
		         stmt.close();
		         c.commit();
		         c.close();
		         
		         confirmacion = true;
		     
	         } catch ( Exception e ) {}
         }
		
		return confirmacion;
	}
	
	
	
	
	public boolean pedidoCurso2(String email, String comments) throws ClassNotFoundException, SQLException {
		boolean confirmacion = false;
		
		if(usuarioValido(email) && comments != "" && comments != null) {
			creaTablas();
			
			Connection c = null;
		    Statement stmt = null;
			
			Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully 1");
			
			try {
		         stmt = c.createStatement();
		         String sql = "INSERT INTO cursosget (email,comments) " +
	             				 "VALUES ('" + email + "', '" + comments + "');"; 
				 stmt.executeUpdate(sql);
	
				 
		         stmt.close();
		         c.commit();
		         c.close();
		         
		         confirmacion = true;
		     
	         } catch ( Exception e ) {}
         }
		
		return confirmacion;
	}
	
	
	
	
	public void creaTablas() {
		Connection c = null;
	    Statement stmt = null;
	      
	    try {
	       Class.forName("org.sqlite.JDBC");
	       c = DriverManager.getConnection("jdbc:sqlite:test.db");
	       System.out.println("Opened database successfully");

	       stmt = c.createStatement();
	       String sql = "CREATE TABLE cursospost " +
	    		   		"(ref 		       INTEGER PRIMARY KEY   AUTOINCREMENT," +
	                    " email 		   VARCHAR(20)	     NOT NULL," +
	                    " products         VARCHAR(20)       NOT NULL," +
	                    " payment          VARCHAR(20)       NOT NULL," +
	                    " grade            INTEGER           DEFAULT 1," +
	                    " amount           INTEGER 			 DEFAULT 0)";
	       stmt.executeUpdate(sql);
	       
	       stmt = c.createStatement();
	       sql = "CREATE TABLE cursosget " +
	    		 "(ref 		       INTEGER PRIMARY KEY   AUTOINCREMENT," +
	             " email 		   VARCHAR(20)	     NOT NULL," +
	             " comments        VARCHAR(200)       DEFAULT 1)";
	       stmt.executeUpdate(sql);
	       
	       stmt.close();
	       c.close();
	    } catch ( Exception e ) {
	    }
	      
	    System.out.println("Table created successfully");
	}
	
	
	
	
	public boolean usuarioValido(String mail) {
		   Connection c = null;
		   Statement stmt = null;
		   boolean existe = false;
		   int resultado = 0;
		   
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT count(*) as existe FROM usuarios where email='" + mail + "';" );
		      
		      while ( rs.next() ) {
		    	  
		    	 resultado = rs.getInt("existe");
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		      
		      
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   
		   System.out.println("Operation done successfully");
		   
		   if (resultado == 1) {
			   existe = true;
		   }
		   
		   return existe;
	}
	
	
	
	
	

}
