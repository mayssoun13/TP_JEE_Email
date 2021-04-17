<%@page import="java.util.List"%>
<%@page import="business.User"%>
<%@page import="dao.DBUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="assets/css/materialize.min.css"  media="screen,projection"/>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
<title>Home</title>
</head>
<body>
	<div class="container">
		<h1 class="center"><i class="medium material-icons">format_list_bulleted</i> Liste des Emails</h1>
		<div class="row">
			<div class="col s8 offset-s2">
			    <form method="get">
				    <div class="card horizontal">
				      <div class="card-stacked">
				        <div class="card-content">
				        	<span class="card-title">
				        		<i class="small material-icons">search</i> Formaulaire de Recherche
				        	</span>
				        	<div class="input-field col s11">
				        	<%String mot = request.getParameter("mot");%>
					          <input id="mot" type="text" class="validate" name="mot" value="<%=(mot==null)?"":mot%>">
					          <label for="mot">Mot clé</label>
					        </div>
				        </div>
				        <div class="card-action">	          
						  <button class="btn waves-effect waves-light blue" type="submit">Rechercher
						    <i class="material-icons right">send</i>
						  </button>
				        </div>
				      </div>
				    </div>
				</form>
	  		</div>
	  	</div>
	   <%if( request.getAttribute("message") != null)
	  	out.println("<blockquote>"+ request.getAttribute("message") +"</blockquote>");
	   %>
		<table class="striped">
        	<tr>
	            <th>Email</th>
	            <th>Prénom</th>
	            <th>Nom</th>
	            <th>Modifier</th>
	            <th>Supprimer</th>
          	</tr>
         <% List<User> list = (mot==null)? DBUser.getList() : DBUser.chercher(mot);
          	for(User u : list) {%>
	        <tr>
	            <td> <%=u.getEmail()%> </td>
	            <td> <%=u.getPrenom()%> </td>
	            <td> <%=u.getNom()%> </td>
	            <td>
	            <form action="Edit.jsp" method="post">
	            	<input type="hidden" name="userId" value="<%=u.getUserId()%>">
	            	<button type="submit" class="btn-floating btn waves-effect waves-light blue">
	            		<i class="material-icons">create</i>
	            	</button>
	            </form>
	            </td>
	            <td>
	            <form action="Delete" method="post">
	            	<input type="hidden" name="userId" value="<%=u.getUserId()%>">
	            	<button type="submit" class="btn-floating btn waves-effect waves-light red">
	            		<i class="material-icons">close</i>
	            	</button>
	            </form>
	            </td>
	        </tr>
	        <%}%>
      	</table>
      	<a class="btn-floating btn waves-effect waves-light green" title="Ajouter" href="Join.jsp">
	    	<i class="material-icons">add</i>
	    </a>
	</div>
	<script type="text/javascript" src="assets/js/materialize.min.js"></script>
</body>
</html>