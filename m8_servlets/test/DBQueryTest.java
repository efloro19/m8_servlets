import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class DBQueryTest {

	@Test
	public void DBConnectionTest() throws IOException {
		boolean prueba = SQLiteJDBCPractica.usuarioValido("eric1@gmail.com");
		
		assertFalse("Fallo DBConnectionTest", prueba);
	}
	
	
	@Test
	public void QueryTest1() throws IOException {
		boolean prueba = SQLiteJDBCPractica.usuarioValido("eric@gmail.com");
		
		assertTrue("Fallo QueryTest1", prueba);
	}
	
	
	@Test
	public void QueryTest2() throws IOException {
		boolean prueba = SQLiteJDBCPractica.usuarioValido("jirafa@gmail.com");
		
		assertFalse("Fallo QueryTest2", prueba);
	}
	
	
	@Test
	public void CodigoTest() throws IOException, ClassNotFoundException, SQLException {
		assertTrue("Fallo CodigoTest", SQLiteJDBCPractica.pedidoCurso2("eric@gmail.com","hola que tal"));
	}
	

}
