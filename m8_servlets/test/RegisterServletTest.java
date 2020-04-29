import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class RegisterServletTest {

	@Test
	public void testEmail1() throws IOException {
		boolean prueba = RegisterServlet.paramsValidos("eric.F@gmail.com","ericF19-","eric");
		
		assertTrue("Fallo testEmail1", prueba);
	}
	
	
	@Test
	public void testEmail2() throws IOException {
		boolean prueba = RegisterServlet.paramsValidos("eric.F@gmailcom","ericF19-","eric");
		
		assertFalse("Fallo testEmail2", prueba);
	}
	
	
	//-------------------------
	
	
	@Test
	public void testPassword1() throws IOException {
		boolean prueba = RegisterServlet.paramsValidos("ericF@gmail.com","Ericf19-","eric");
		
		assertTrue("Fallo testPassword1", prueba);
	}
	
	
	@Test
	public void testPassword2() throws IOException {
		boolean prueba = RegisterServlet.paramsValidos("ericF@gmail.com","eri19-","eric");
		
		assertFalse("Fallo testPassword2", prueba);
	}
	
	
	//-------------------------
	
	
	@Test
	public void testNick1() throws IOException {
		boolean prueba = RegisterServlet.paramsValidos("ericF@gmail.com","ericF19-","ericfloro");
		
		assertTrue("Fallo testNick1", prueba);
	}
	
	
	@Test
	public void testNick2() throws IOException {
		boolean prueba = RegisterServlet.paramsValidos("ericF@gmail.com","ericF19-","-?¡_");
		
		assertFalse("Fallo testNick2", prueba);
	}
	

}
