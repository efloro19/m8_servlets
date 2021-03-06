

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SQLiteJDBCPractica sqlite = new SQLiteJDBCPractica();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Procedimiento que comprueba si el usuario que intenta hacer login existe o no
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		if (sqlite.existeUsuario(email, pwd)) {
			request.setAttribute("email", email);
			request.getRequestDispatcher("jsp/Index2.jsp").forward(request, response);
		
		} else {
			request.setAttribute("email", email);
			request.getRequestDispatcher("Fail/fail.jsp").forward(request, response);
		}
		
		//response.sendRedirect("Success/success.jsp");
	}


}
