<%-- 
    Document   : signIn.jsp
    Created on : Mar 7, 2016, 3:30:47 PM
    Author     : Quade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" 
			  rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  
			  media="screen,projection"/>
		<link type="text/css" rel="stylesheet" href="css/signIn.css"  />
    </head>
    <body>
		<jsp:include page="navbar.jsp" />
		<div class="container">
			<div class="row center">
				<div class="col l8 offset-l2
					            m10 offset-m1
								s12">
					<form method="POST" action="Authenticate">
						<input type="text" id="username" name="username" 
							   placeholder="Enter a username" />
						<input type="password" id="password" name="password" 
							   placeholder="Enter a password" />
						<input class="btn waves-effect waves-light red lighten-1" 
							   type="submit" value="Sign In" />
					</form>
				</div>
		</div>
		<script type="text/javascript" src="src/jquery.min.js"></script>
		<script type="text/javascript" src="src/materialize.min.js"></script>
    </body>
</html>
