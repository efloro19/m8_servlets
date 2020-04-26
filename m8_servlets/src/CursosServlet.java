

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CursosServlet
 */
@WebServlet("/CursosServlet")
public class CursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SQLiteJDBCPractica sqlite = new SQLiteJDBCPractica();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productos = "";
		int precio = 0;
		String eso = request.getParameter("eso");
		if(eso != "" && eso != null) {
			productos = productos + eso + "-";
			precio = precio + 100;
		}
		String bachi = request.getParameter("bachi");
		if(bachi != "" && bachi != null) {
			productos = productos + bachi + "-";
			precio = precio + 100;
		}
		String daw = request.getParameter("daw");
		if(daw != "" && daw != null) {
			productos = productos + daw + "-";
			precio = precio + 100;
		}
		String dam = request.getParameter("dam");
		if(dam != "" && dam != null) {
			productos = productos + dam + "-";
			precio = precio + 100;
		}
		String asix = request.getParameter("asix");
		if(asix != "" && asix != null) {
			productos = productos + asix + "-";
			precio = precio + 100;
		}
		
		String pago = request.getParameter("pago");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		
		
		if(productos != "" && productos != null && email != "" && email != null) {
			System.out.println("-");
			productos = productos.substring(0,productos.length() - 2);
		} else {
			request.setAttribute("email", email);
			request.getRequestDispatcher("Fail/fail3.jsp").forward(request, response);
		}
		
		
		
		
		try {
			if (sqlite.pedidoCurso1(productos, pago, email, grade, precio)) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("Success/success3.jsp").forward(request, response);
			
			} else {
				request.setAttribute("email", email);
				request.getRequestDispatcher("Fail/fail3.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			request.setAttribute("email", email);
			request.getRequestDispatcher("Fail/fail3.jsp").forward(request, response);
		}
		
		//response.sendRedirect("Success/success.jsp");
	
	}

	
	
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		System.out.println("0");
		String comments = request.getParameter("comments");
		
		System.out.println("1");
		System.out.println(comments);
		System.out.println("2");
		
		try {
			if (sqlite.pedidoCurso2(email, comments)) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("Success/success3.jsp").forward(request, response);
			
			} else {
				request.setAttribute("email", email);
				request.getRequestDispatcher("Fail/fail3.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			request.setAttribute("email", email);
			request.getRequestDispatcher("Fail/fail3.jsp").forward(request, response);
		}
		
		//response.sendRedirect("Success/success.jsp");
	}

}
