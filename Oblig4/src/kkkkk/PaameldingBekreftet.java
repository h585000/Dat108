package kkkkk;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaameldingBekreftet
 */
@WebServlet("/Bekreftet")
public class PaameldingBekreftet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaameldingBekreftet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    
    	
    	
		request.getRequestDispatcher("WEB-INF/Paameldingsbekreftelse.jsp").forward(request,response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	response.sendRedirect("/deltagerliste");
    	
    	
    }
}
