
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SQLiteJDBCPractica {
	static Properties properties = new Properties();
	InputStream is = null;
	
	
	
	/**
	 * Función que registra un nuevo usuario en la bbdd
	 * 
	 * @return true si se ha registrado correctamente
	 * @return false si no se ha podido registrar el usuario
	 */
	public boolean setUsuario(String mail, String passwd, String user) throws IOException {
	      Connection c = null;
	      Statement stmt = null;
	      properties.load(SQLiteJDBCPractica.class.getClassLoader().getResourceAsStream("configuracion.properties"));
	      
	      try {
	         //Class.forName("org.sqlite.JDBC");
	    	 Class.forName(properties.getProperty("classForName"));
	         //c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    	 c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
	        		 Class.forName(properties.getProperty("classForName"));
	    	    	 c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
	    		   
	        	   Class.forName(properties.getProperty("classForName"));
	        	   c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
	
	
	/**
	 * Función que comprueba si los datos del usuario coinciden con los de la bbdd
	 * 
	 * @return true si los datos del usuario coinciden
	 * @return false si los datos del usuario no coinciden
	 */
	public boolean existeUsuario(String mail, String passwd) throws IOException {
		   Connection c = null;
		   Statement stmt = null;
		   boolean existe = false;
		   int resultado = 0;
		   properties.load(SQLiteJDBCPractica.class.getClassLoader().getResourceAsStream("configuracion.properties"));
		   
		   try {
			  Class.forName(properties.getProperty("classForName"));
  	    	  c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
	
	
	
	
	/**
	 * Función que registra la compra de cursos en la bbdd por metodo POST
	 * 
	 * @return true si los datos se han registrado correctamente
	 * @return false si los datos no se han podido registrar correctamente
	 */
	public static boolean pedidoCurso1(String productos, String pago, String email, String grade, int cantidad) throws ClassNotFoundException, SQLException, IOException {
		boolean confirmacion = false;
		properties.load(SQLiteJDBCPractica.class.getClassLoader().getResourceAsStream("configuracion.properties"));
		
		if(usuarioValido(email)) {
			creaTablas();
			
			Connection c = null;
		    Statement stmt = null;
			
		    Class.forName(properties.getProperty("classForName"));
	    	c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
	
	
	
	/**
	 * Función que registra la compra de cursos en la bbdd por metodo GET
	 * 
	 * @return true si los datos se han registrado correctamente
	 * @return false si los datos no se han podido registrar correctamente
	 */
	public static boolean pedidoCurso2(String email, String comments) throws ClassNotFoundException, SQLException, IOException {
		boolean confirmacion = false;
		properties.load(SQLiteJDBCPractica.class.getClassLoader().getResourceAsStream("configuracion.properties"));
		
		if(usuarioValido(email) && comments != "" && comments != null) {
			creaTablas();
			
			Connection c = null;
		    Statement stmt = null;
			
		    Class.forName(properties.getProperty("classForName"));
	    	c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
	
	
	
	/**
	 * Procedimiento para crear las tablas de cursos
	 * 
	 */
	public static void creaTablas() throws IOException {
		Connection c = null;
	    Statement stmt = null;
	    properties.load(SQLiteJDBCPractica.class.getClassLoader().getResourceAsStream("configuracion.properties"));
	      
	    try {
	    	Class.forName(properties.getProperty("classForName"));
	    	c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
	
	
	
	/**
	 * Función para comprobar si un usuario existe en la bbdd
	 * 
	 * @return true si el usuario existe
	 * @return false si el usuario no existe
	 * 
	 */
	public static boolean usuarioValido(String mail) throws IOException {
		   Connection c = null;
		   Statement stmt = null;
		   boolean existe = false;
		   int resultado = 0;
		   properties.load(SQLiteJDBCPractica.class.getClassLoader().getResourceAsStream("configuracion.properties"));
		   
		   try {
			  Class.forName(properties.getProperty("classForName"));
  	    	  c = DriverManager.getConnection(properties.getProperty("rutaDB"));
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
