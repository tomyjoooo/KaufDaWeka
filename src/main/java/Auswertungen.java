import weka.*;
import weka.core.Instances;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Auswertungen
 */
public class Auswertungen extends HttpServlet {
	private static final long serialVersionUID = 2L;

    /**
     * Default constructor. 
     */
    public Auswertungen() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImportExport impexp = new ImportExport();
		Instances alleDaten = impexp.loadCSV();
		PrintWriter out = response.getWriter();
		String kennzeichen = request.getParameter("Kennzeichen");
		
		out.append("HALLOO");
		switch(kennzeichen){
			
			case("Top5KundenTag"):
				Top5 top5kt = new Top5(alleDaten);
				top5kt.setCriteria("Einkaufstag");
				top5kt.getTop5();
				top5kt.reset();
				out.append(" ");
			break;
			
			case("Top5KundenZeit"):
				Top5 top5kz = new Top5(alleDaten);
				top5kz.setCriteria("Einkaufsuhrzeit");
				ArrayList<Daten> blah = top5kz.getTop5();
				top5kz.reset();
				
				out.append(blah.toString());
			break;
			
			case("Top5KundenAlter"):
				Top5 top5ka = new Top5(alleDaten);
				top5ka.setCriteria("Einkaufsalter");
				top5ka.getTop5();
				top5ka.reset();
				out.append("Patricksfunktion3");
			break;
			
			case("Persongruppe"):
				out.append("Patricksfunktion4");
			break;
			
			case("Warenkorb"):
				out.append("Patricksfunktion5");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
