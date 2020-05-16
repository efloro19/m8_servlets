

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SQLiteJDBCPractica sqlite = new SQLiteJDBCPractica();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Procedimiento para validar los datos introducidos del usuario y registrarlo en la bbdd
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String usuario = request.getParameter("usuario");
		
		boolean parametrosValidos = paramsValidos(email,pwd,usuario);
		
		if (parametrosValidos) {
			//respuesta(response, "login ok");
			
			if (sqlite.setUsuario(email, pwd, usuario)) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("Success/success.jsp").forward(request, response);
			
			} else {
				request.setAttribute("email", email);
				request.getRequestDispatcher("Fail/fail2.jsp").forward(request, response);
			}
			
			//response.sendRedirect("Success/success.jsp");
		} else {
			//respuesta(response, "invalid login");
			
			request.setAttribute("email", email);
			request.getRequestDispatcher("Fail/fail.jsp").forward(request, response);
			
			//response.sendRedirect("Fail/fail.jsp");
		}
	}

	
	/**
	 * Funcion para validar los datos introducidos del usuario
	 * 
	 * @return true si son parametros validos
	 * @return false si alguno de los parametros no es valido
	 * 
	 */
	public static boolean paramsValidos(String email, String pwd, String usuario) throws IOException {
		boolean validos = false;
		
		Pattern pEmail = Pattern.compile("^[-a-zA-Z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-zA-Z0-9~!$%^&*_=+}{\\'?]+)*@([a-zA-Z0-9_][-a-zA-Z0-9_]*(\\.[-a-zA-Z0-9_]+)*\\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-zA-Z][a-zA-Z])|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$");
		Matcher mEmail = pEmail.matcher(email);
		
		Pattern pPass = Pattern.compile("([a-zA-Z0-9\\?_\\-\\$%]){8,}");
		Matcher mPass = pPass.matcher(pwd);
		
		Pattern pUsuario = Pattern.compile("[a-zA-Z0-9]+");
		Matcher mUsuario = pUsuario.matcher(usuario);
		
		if (mEmail.find() && mPass.find() && mUsuario.find()) {
			validos = true;
		}
			
		return validos;
	}

}
