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
			<h1 class="display-4">Top 5-Artikel</h1>
			<p class="lead px-2">Hier kommt spÃ¤ter vielleicht noch Text hin</p>
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
						<a class="nav-link" href="top5kundenwochentag.jsp">nach Wochentag</a>
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
						<a class="nav-link active" href="top5artikel.jsp">nach Wochentag</a>
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
		
				<div class="card-deck">
		
					<div class="card border-primary">
						<h3 class="card-header bg-primary" style="color:white;">Verkaufte Artikel pro Wochentag</h3>
						<div class="card-body">
							<canvas id="card1"></canvas>
						</div>
					</div>
					
					<div class="card border-primary">
						<h3 class="card-header bg-primary" style="color:white;">Verkaufte Artikel</h3>
						<div class="card-body">
							<canvas id="card2"></canvas>
						</div>
					</div>
					
				</div>
				<div class="card-deck"style="margin-top:30px;">
				
					<div class="card border-primary">
						<h3 class="card-header bg-primary" style="color:white;">Verkaufte Artikel nach Geschlecht</h3>
						<div class="card-body">
							<canvas id="card3"></canvas>
						</div>
					</div>
					
					<div class="card border-primary">
						<h3 class="card-header bg-primary" style="color:white;">Diagramm 4</h3>
						<div class="card-body">
							Hier kommt ein Diagramm hin
						</div>
					</div>
					
				</div>
				
			</div>
		</div>
	</div>
	
	<div style="margin:100px;"></div>
	
	<script>
	Chart.defaults.global.defaultFontSize = 20;
	Chart.defaults.global.defaultFontColor = 'black';
	Chart.defaults.global.animation.duration = 0;
	var chart1 = document.getElementById('card1');
	var barChart1 = new Chart(chart1, {
		type: 'bar',
		data: {
			labels: ["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"],
			datasets: [{
				label: "Verkaufte Artikel",
				backgroundColor: 'rgba(255, 150, 20)',
				data: [43, 35, 38, 32, 39, 48],
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

	var chart2 = document.getElementById('card2');
	var pieChart1 = new Chart(chart2, {
		type: 'pie',
		data: {
			labels: ["GetrÃ¤nke", "Obst", "Fleisch", "GemÃ¼se", "Drogerieartikel", "Milchprodukte", "Spirituosen", "Backwaren"],
			datasets: [{
				label: "Verkaufte Artikel",
				backgroundColor: [
					'rgba(255, 200, 20)',
					'rgba(255, 100, 20)',
					'rgba(50, 250, 200)',
					'rgba(50, 250, 100)',
					'rgba(5, 100, 255)',
					'rgba(5, 100, 160)',
					'rgba(160, 155, 200)',
					'rgba(250, 20, 15)'
				],
				data: [103, 89, 78, 82, 65, 74, 31, 62]
			}]
		},
		options: {
			legend: {
				position: 'right'
			}
		}
	});
	
	var chart3 = document.getElementById('card3');
	var barChart2 = new Chart(chart3, {
		type: 'bar',
		data: {
			labels: ["Fleisch", "GemÃ¼se", "Spirituosen", "Drogerieartikel"],
			datasets: [{
				label: "MÃ¤nner",
				backgroundColor: 'rgba(25,25,255)',
				data: [34, 23, 19, 13]
			}, {
				label: "Frauen",
				backgroundColor: 'rgba(255,25,25)',
				data: [18, 33, 12, 29]
			}]
		},
		options: {
			scales: {
				xAxes: [{
					stacked: true
				}],
				yAxes: [{
					stacked: true,
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