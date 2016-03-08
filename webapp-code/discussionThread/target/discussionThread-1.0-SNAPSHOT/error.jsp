<%-- 
    Document   : error
    Created on : Mar 8, 2016, 12:49:46 AM
    Author     : Quade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Sign In</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" 
			  rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  
			  media="screen,projection"/>
    </head>
    <body>
		<jsp:include page="navbar.jsp" />
		<div class="container">
			<br />
			<div class="row">
				<div class="center">
					<Span>
						Looks like you put in the wrong information click
						<a href="signIn.jsp">here</a>
						to go back.
					</span>
				</div>
			</div>
		</div>
    </body>
</html>
