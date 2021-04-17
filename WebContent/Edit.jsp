<%@page import="dao.DBUser"%>
<%@page import="business.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Modification</title>
	<link type="text/css" rel="stylesheet" href="assets/css/materialize.min.css"  media="screen,projection"/>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
</head>
<body>
	<% 	if(request.getParameter("userId") == null || request.getMethod().equals("GET")){
			request.setAttribute("message", "Selectionnez un utilisateur d'abord !");
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
		int id = Integer.parseInt(request.getParameter("userId"));
		User u = DBUser.get(id);%>
	<div class="container">
	<h2 class="center"><i class="medium material-icons">create</i> Formulaire de Modification</h2>
		<div class="row">
			<div class="col s8 offset-s2">
			    <form action="Edit" method="post">
				    <div class="card horizontal">
				      <div class="card-stacked">
				        <div class="card-content">
				        	<span class="card-title">
				        		Remplissez le formualire suivant
				        	</span>
				        	<input type="hidden" class="validate" name="userId" value="<%=u.getUserId()%>" required>
				        	<div class="input-field col s11">
					          <input id="email" type="email" class="validate" name="email" value="<%=u.getEmail()%>" required>
					          <label for="email">Email</label>
					        </div>
					        <div class="input-field col s11">
					          <input id="prenom" type="text" class="validate" name="prenom" value="<%=u.getPrenom()%>" required>
					          <label for="prenom">Prénom</label>
					        </div>
					        <div class="input-field col s11">
					          <input id="nom" type="text" class="validate" name="nom" value="<%=u.getNom()%>" required>
					          <label for="nom">Nom</label>
					        </div>
				        </div>
				        <div class="card-action">	          
						  <button class="btn waves-effect waves-light blue" type="submit">Modofier
						    <i class="material-icons right">create</i>
						  </button>
				        </div>
				      </div>
				    </div>
				</form>
	  		</div>
	  	</div>
	 </div>
	 <script type="text/javascript" src="assets/js/materialize.min.js"></script>
</body>
</html>