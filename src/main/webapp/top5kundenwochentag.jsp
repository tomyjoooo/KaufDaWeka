<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="de">
<% String login = (String)request.getSession().getAttribute("login");
	if (login.equals("0")){
		response.sendRedirect("checkPassword");
	}%>
<!DOCTYPE html>
<html lang="de">
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
			<h1 class="display-4">Top 5-Kunden</h1>
			<p class="lead px-2">nach Wochentag</p>
		</div>
	</div>
	
	<div class="container-fluid">
		
		<div class="row">
			<div class="col-2">
			 
				<ul class="nav flex-column nav-pills">
					<li class="nav-item">
						<a class="navbar-brand text-center" href="startseite.jsp"><h4>KaufDort</h4></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="startseite.jsp">Startseite</a>
					</li>
					<li class="nav-item mt-2 px-2">
						Top 5-Kunden
					</li>
					<li class="nav-item">
						<a class="nav-link active" href="top5kundenwochentag.jsp">nach Wochentag</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5kundenuhrzeit.jsp">nach Uhrzeit</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="top5kundenalter.jsp">nach Altersgruppe</a>
					</li>
					<li class="nav-item mt-2 px-2">
						Top 5-Artikel
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
		
				<div class="container">
					<div class="card border-primary">
						<h3 class="card-header bg-primary" style="color:white;">Top 5-Kunden nach Wochentag</h3>
						<div class="card-body">
							<canvas id="card1"></canvas>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	<script>
	Chart.defaults.global.defaultFontSize = 20;
	Chart.defaults.global.defaultFontColor = 'black';
	Chart.defaults.global.animation.duration = 0;
	var chart1 = document.getElementById('card1');
	var barChart1 = new Chart(chart1, {
		type: 'bar',
		data: {
			labels: ["Samstag", "Montag", "Freitag", "Mittwoch", "Dienstag"],
			datasets: [{
				label: "Verkaufte Artikel",
				backgroundColor: 'rgba(255, 150, 20)',
				data: [48, 43, 39, 38, 34],
			}]
		},
		options: {
			legend: {
				display: false
			},
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: true
					}
				}]
			}
		}
	});
	</script>

  </body>
</html>