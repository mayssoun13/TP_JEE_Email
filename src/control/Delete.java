package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUser;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Delete() {}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/Home.jsp").forward(request, response);
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String message = "";
    	int id = Integer.parseInt(request.getParameter("userId"));
    	
    	if(DBUser.delete(id)>0)
    		message = "Utilisateur suprimé avec succés";
    	else
    		message = "Erreur de suppression !";
    	
    	request.setAttribute("message", message);
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}
	
}