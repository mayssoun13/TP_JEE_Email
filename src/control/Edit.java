package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.User;
import dao.DBUser;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Edit() {}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
    	int id = Integer.parseInt(request.getParameter("userId"));
    	
    	User u =new User();
    	u.setEmail(request.getParameter("email").trim());
    	u.setPrenom(request.getParameter("prenom").trim());
    	u.setNom(request.getParameter("nom").trim());
    	
    	
    	if(DBUser.update(u, id) == 1)
    		message = "Utilisateur modifié avec succés";
    	else
    		message = "Erreur de modification";
    	
    	request.setAttribute("message", message);
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

}
