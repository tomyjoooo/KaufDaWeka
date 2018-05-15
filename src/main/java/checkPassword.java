

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkPassword
 */
public class checkPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String password = request.getParameter("password");
		
		if (password==null) {
			session.setAttribute("login", "0");
			session.setAttribute("error", null);
			response.sendRedirect( "login.jsp" );
		}else {
			if (password.equals("1234")) {
				session.setAttribute("login", "1");
				session.setAttribute("error", null);
		        response.sendRedirect( "startseite.jsp" );
			}else {
				session.setAttribute("login", "0");
				session.setAttribute("error", "Das Passwort wurde falsch Eingegeben!");
				response.sendRedirect( "login.jsp" );
			}
		}

        
	}

}
