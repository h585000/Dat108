package kkkkk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BrukerDao brukerDAO;

       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        request.getRequestDispatcher("WEB-INF/Paameldingsskjema.jsp")
	        		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Validering val =new Validering(request);
		request.setAttribute("validering", val);
		
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		String passordrep = request.getParameter("passordRepetert");
		String kjonn = request.getParameter("kjonn");
		
		
		
		List<Bruker> brukerliste = brukerDAO.hentAlleBrukere();
		
		Bruker b = brukerliste.stream().filter(i -> i.getMobil().equals(val.getMobil())).findAny().orElse(null);
		
		if(b != null && !passord.equals(passordrep)) {
			System.out.println("tlf ikke gydlig");
			request.setAttribute("feilmelding", "Mobilnummer er allerede registrert. Passord og passordrepetert er ikke like");
			
			request.getRequestDispatcher("WEB-INF/Paameldingsskjema.jsp").forward(request, response);
		
		}
			else if(b != null ) {
				System.out.println("tlf ikke gydlig");
				request.setAttribute("feilmelding", "Mobilnummer er allerede registrert.");
				request.getRequestDispatcher("WEB-INF/Paameldingsskjema.jsp").forward(request, response);
			}
			else if(!passord.equals(passordrep)) {
				
				request.setAttribute("feilmelding", "Passord og passordrepetert må være det samme");
				request.getRequestDispatcher("WEB-INF/Paameldingsskjema.jsp").forward(request, response);
			}
			 
			
		
		else {
			
		
		 Bruker bruker1 = new Bruker();
		 bruker1.setMobil(mobil);
		 bruker1.setFornavn(fornavn);
		 bruker1.setEtternavn(etternavn);
		 bruker1.setKjonn(kjonn);
		 
		 request.getSession().setAttribute("fornavn", request.getParameter("fornavn"));
			request.getSession().setAttribute("etternavn", request.getParameter("etternavn"));
			request.getSession().setAttribute("mobil", request.getParameter("mobil"));
			request.getSession().setAttribute("kjonn", request.getParameter("kjonn"));
		 
		 Passord pass = Passord.lagPassord(passord);
         bruker1.setPassord(pass);
         
         
         
        
         brukerDAO.lagreNyBruker(bruker1);
			  response.sendRedirect("/Oblig4/Bekreftet");
		}
		 
		
         
         
		
	}
}
