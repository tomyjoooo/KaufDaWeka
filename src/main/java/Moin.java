

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Moin
 */
public class Moin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Moin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// Die folgende INstanzierung ist ausgedacht!
		// PAtrick fragen wie der das vor hat
		//Weka weka = new Weka();
		//String[] kennzeichen = request.getParameterValues("Kennzeichen");
		String rueckgabe = "moin";
		/*if (kennzeichen[0]=="top5tage") {
			//funktionsnamen hab ich mir auch erst mal ausgedacht
			//rueckgabe = weka.top5tage();
		}else if(kennzeichen[0]=="top5uhrzeiten"){
			//rueckgabe = weka.toptuhrzeiten();
		}*/
		out.append(rueckgabe);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//HIER DATEI ANNEHMEN UND AN WEKA WEITERGEBEN
	}

}
