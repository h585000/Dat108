package kkkkk;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deltagerliste")
public class DeltagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	BrukerDao brukerDAO;
    
    public DeltagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bruker> brukerliste = brukerDAO.hentAlleBrukere();
		
		request.getSession().setAttribute("brukerliste", brukerliste);
		String sessionMobil = (String) request.getSession().getAttribute("mobil");

		
		request.getRequestDispatcher("WEB-INF/Deltagerliste.jsp")
 		.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/Loggut");
		
		
	}
	

	

}
