<%-- 
    Document   : index.jsp
    Created on : Mar 7, 2016, 3:30:10 PM
    Author     : Quade
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" 
			  rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  
			  media="screen,projection"/>
		<link type="text/css" rel="stylesheet" href="css/index.css"  
    </head>
    <body>
	    <%
		    if (session.getAttribute("username") == null) {
			response.sendRedirect("signIn.jsp");	
		    }
	    %>

		<jsp:include page="navbar.jsp" />

		<div class="container">
			<div id="post_wrapper" class="row">
				<ul>
					<c:set var="numComments" value="${fn:length(comments)}" />
					<c:forEach var="i" begin="1" end="${numComments}" step="1">
						<c:set var="comment" value="${comments[numComments - i]}" />
						<div class="post row">
							<li class="col l3 m4 s5 card">${comment}</li>
						</div>
						</c:forEach>
				</ul>
			</div>
				
			<div class="row">
				<div id="logout_wrapper" class="row">
					<form action="Logout">
						Hey,
						<span id="username"></span>,
						click
						<input id="logout" class="blue-text lighten-1" 
							   type="submit" value="here" />
						to logout
					</form>
				</div>
				<form method="POST" action="AddCommentToDatabase">
					<div class="col l10 m10 s12">
						<input id="comment_entry" type="text" name="comment_entry"
							   tabindex="-1" placeholder="Enter your thoughts" />
					</div>
					<div class="col l2 m2 s12">
					<button class="btn red lighten-1 waves-light waves-effect" 
							type="submit" id="post">
						Post
						<i class="material-icons right">send</i>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="src/jquery.min.js"></script>
		<script type="text/javascript" src="src/materialize.min.js"></script>
		<script type="text/javascript" src="src/index.js"></script>
    </body>
</html>
