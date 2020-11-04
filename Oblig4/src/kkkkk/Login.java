package kkkkk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BrukerDao brukerDAO;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String loginMessage = "";

		if (request.getParameter("requiresLogin") != null) {
			loginMessage = "Forespørselen din krever pålogging. " + "(Du kan ha blitt logget ut automatisk)";

		} else if (request.getParameter("invalidUsername") != null) {
			loginMessage = "Ugyldig brukernavn eller passord";
		}

		request.setAttribute("loginMessage", loginMessage);

		request.getRequestDispatcher("WEB-INF/Loggin.jsp").forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		String Smobil = request.getParameter("mobil");
		//int mobil = Integer.parseInt(Smobil);
		String passord = request.getParameter("passord");
		
		
		
		
		Bruker bruker1 = brukerDAO.hentBruker(Smobil);
		
		response.setContentType("text/plain");
		
		
		
			if(bruker1!=null) {
				
				System.out.println("mobilnr stemmer");
				System.out.println("passordhash: " + bruker1.getPassord().getPwd_hash());
				System.out.println("passordhash2: " + PassordHjelper.hashMedSalt2(passord, bruker1.getPassord().getPwd_salt()));

				
				if(PassordHjelper.validerMedSalt2(passord, bruker1.getPassord().getPwd_salt(), bruker1.getPassord().getPwd_hash())) {
					System.out.println("Passord stemmer også");
					response.sendRedirect("/deltagerliste");
	
		}
		
		
		
		
		
				
			
			}
	

	}
}

	
