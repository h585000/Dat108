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
		
		

		request.getRequestDispatcher("WEB-INF/Loggin.jsp").forward(request, response);
	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Validering val = new Validering(request);
		
		String Smobil = request.getParameter("mobil");
		//int mobil = Integer.parseInt(Smobil);
		String passord = request.getParameter("passord");
		
		request.getSession().setAttribute("mobil", request.getParameter("mobil"));
		
		
		
		
		Bruker bruker1 = brukerDAO.hentBruker(Smobil);
		
		String salt = bruker1.getPassord().getPwd_salt();
		String hash = PassordHjelper.hashMedSalt2(passord, salt);
		
		System.out.println(salt);
		System.out.println(hash);
		
		Passord pass = new Passord(salt,hash);
		bruker1.getPassord().getPwd_hash();
		
		
		
		
		
		 
			if(bruker1!=null ) {
				
				
				
				System.out.println(bruker1.getPassord());
				
			

				
				if(bruker1.getPassord().equals(pass)) {
					System.out.println("Passord stemmer også");
					response.sendRedirect("/deltagerliste");
	
		}		else {
			response.sendRedirect("/Oblig4/Login");
			request.getSession().setAttribute("feilmelding", "Passordet er feil vennligst prøv igjen");
		}
		
		
		
		
		
				
			
			}
	


	}
	
}


	
