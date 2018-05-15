<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="de">
  <head>
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
	
	<style>
		.container{
			width:26%;
		}
	</style>
		
    <title>KaufDort</title>
	
  </head>
  <body>
  
	<div class="container" style="margin-top:250px;">
		<img src="imgs/KaufDort.png" class="img-fluid mx-auto d-block" alt="KaufDort">
		<form action="checkPassword" method="post">
			<div class="form-group">
				<h3 align="center" style="margin-bottom:20px">Bitte geben Sie Ihr Passwort ein<h3>
				<% String error = "";
					if ((String)request.getSession().getAttribute("error")!=null){
						error = (String)request.getSession().getAttribute("error");
					}%>
				<%= error %>
				<input type="password" name="password" class="form-control" title="Dieses Feld muss ausgefÃ¼llt werden" placeholder="Passwort" required autofocus>
				<input type="submit" value="Login" />
			</div>
			<a href="startseite.jsp" class="btn btn-lg btn-primary btn-block">Login</a>
		</form>
	</div>	
		
  </body>
</html>