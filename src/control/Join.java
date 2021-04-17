package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.User;
import dao.DBUser;

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Join() {super();}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		User user = new User();
		user.setEmail(request.getParameter("email").trim());
		user.setPrenom(request.getParameter("prenom").trim());
		user.setNom(request.getParameter("nom").trim());
		
		if (DBUser.insert(user) > 0) 
			message = "Utilisateur ajouté avec succés";
		else
			message = "Erreur d'ajout";
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

}