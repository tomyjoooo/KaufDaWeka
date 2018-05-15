<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="de">
<% String login = (String)request.getSession().getAttribute("login");
	if (login.equals("0")){
		response.sendRedirect("checkPassword");
	}%>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
	
	<!-- Chart.js -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

    <title>KaufDort</title>
	
  </head>
  <body>
	<div class="jumbotron jumbotron-fluid bg-primary" style="color:white;">
		<div class="container">
			<h1 class="display-4">Startseite</h1>
			<p class="lead px-2">Das hier ist die Startseite</p>
		</div>
	</div>
		
	<div class="container-fluid">
	
		<div class="row">
			<div class="col-2">
             
				<ul class="nav flex-column nav-pills">
					<li class="nav-item">
						<a class="navbar-brand text-dark" href="startseite.jsp"><h3>KaufDort</h3></a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" href="startseite.jsp">Startseite</a>
					</li>
					<li class="nav-item mt-2 px-2">
						<strong>Top 5-Kunden</strong>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5kundenwochentag.jsp">nach Wochentag</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5kundenuhrzeit.jsp">nach Uhrzeit</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5kundenalter.jsp">nach Altersgruppe</a>
					</li>
					<li class="nav-item mt-2 px-2">
						<strong>Top 5-Artikel</strong>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5artikel.jsp">nach Wochentag</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5artikel.jsp">nach Uhrzeit</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5artikel.jsp">insgesamt</a>
					</li>
				</ul>

			</div>
			
			<div class="col-10">
		
				<div class="container pb-5">
					<form method="post" action="UploadServlet" enctype="multipart/form-data">
						<label>Auszuwertenden Datensatz auswählen (.csv-Datei)</label> 
						<input type="file" name="uploadFile" accept=".csv" />
						<br/>
						<input type="submit" value="Hochladen" />
					</form>
				</div>
				
				<div class="container pt-3 border-top border-primary">
					<h5>Vorherige Auswertungen anschauen:</h5>
					
					<div class="btn-group btn-group-toggle mt-2" data-toggle="buttons">
						<label class="btn btn-primary active btn-lg">
							<input type="radio" name="options" id="option1" autocomplete="off" checked> 1
						</label>
						<label class="btn btn-primary btn-lg">
							<input type="radio" name="options" id="option2" autocomplete="off"> 2
						</label>
						<label class="btn btn-primary btn-lg">
							<input type="radio" name="options" id="option3" autocomplete="off"> 3
						</label>
						<label class="btn btn-primary btn-lg">
							<input type="radio" name="options" id="option4" autocomplete="off"> 4
						</label>
						<label class="btn btn-primary btn-lg">
							<input type="radio" name="options" id="option5" autocomplete="off"> 5
						</label>
					</div>
				</div>
				
			</div>
		</div>
		
	</div>
			
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="js/bootstrap.min.js"></script>
	
  </body>
</html>