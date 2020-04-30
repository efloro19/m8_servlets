<span style="color: #000000;"><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="description" content="Exemple pàgina">
	<meta name="keywords" content="HTML,CSS,XML,JavaScript">
	<meta name="author" content="Eric Floro">

	<title>Cursos - Eric Floro </title>

	<link href="css/style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


	<link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">

	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<style>
		body {
			font-family: 'Roboto', sans-serif;
			background-color: #6699ff;
		}
	</style>


</head>

<body>
	
	<div class="container">
		<div class="row">
		
			<div class="col-2 content2 contentTitle">
				<a></a>
			</div>
			<div class="col-8 contentTitle">
				<h1>Post FORM Courses</h1>
			</div>
			<div class="col-2 content3 contentTitle">
				<a> Logged as ${email} <%= request.getParameter("email") %> </a>
			</div>
		</div>
	</div>

	<form action="../CursosServlet" method="post">
		<div class="container campos">
		
			<div class="row campo">
				<div class="col-1 contentInsert">
					<a></a>
				</div>
				<div class="col-2 contentField">
					<input type="checkbox" id="eso" name="eso" value="eso">
					<a>ESO</a><br>
					<a>100 euros</a>
				</div>
				<div class="col-2 contentField">
					<input type="checkbox" id="bachi" name="bachi" value="bachi">
					<a>Batxillerat</a><br>
					<a>100 euros</a>
				</div>
				<div class="col-2 contentField">
					<input type="checkbox" id="daw" name="daw" value="daw">
					<a>DAW</a><br>
					<a>100 euros</a>
				</div>
				<div class="col-2 contentField">
					<input type="checkbox" id="dam" name="dam" value="dam">
					<a>DAM</a><br>
					<a>100 euros</a>
				</div>
				<div class="col-2 contentField">
					<input type="checkbox" id="asix" name="asix" value="asix">
					<a>ASIX</a><br>
					<a>100 euros</a>
				</div>
				<div class="col-1 contentInsert">
					<a></a>
				</div>
			</div>
			
			<div class="row campo">
				<div class="col-1 contentInsert">
					<a></a>
				</div>
				<div class="col-10 contentPayment">
					<div>
						<a>Payment Mode:</a>
					</div>
					<div>
						<input type="radio" id="cash" name="pago" value="cash">
						<a class="paymentOption">Cash</a>
						<input type="radio" id="credito" name="pago" value="creditCard">
						<a class="paymentOption">Credit Card</a>
						<input type="radio" id="paypal" name="pago" value="paypal">
						<a>PayPal</a>
					</div>
				</div>
				<div class="col-1 contentInsert">
					<a></a>
				</div>
			</div>
			
			
			<div class="row campo">
				<div class="col-1 contentInsert">
					<a></a>
				</div>
				<div class="col-1 contentField2 content">
					<a>Grade</a>
				</div>
				<div class="col-1 selectList content">
					<select id="grade" name="grade">
						<option selected value="1">Grade</option>
						<option value="1">1</option>
						<option value="2">2</option>
					</select>
				</div>
				<div class="col-1 contentField3 content">
					<input type="hidden" id="email" name="email" value="<%= request.getParameter("email") %>"/>
					<input type="submit" value="Send">
				</div>
				<div class="col-1 contentInsert">
					<a></a>
				</div>
			</div>
	
		</div>
	</form>
	
	
	
	<div class="container">
		<div class="row">
			<div class="col-11 contentTitle content">
				<h1>Get FORM Courses</h1>
			</div>
		</div>
	</div>
	
	<form action="../CursosServlet" method="get">
		<div class="container campos">
		
			<div class="row campo">
				<div class="col-1 contentInsert">
					<a></a>
				</div>
				<div class="col-2 contentField2 content">
					<a>Comments</a>
				</div>
				<div class="col-3 content">
					<textarea id="comments" name="comments" rows="3" cols="50"></textarea>
				</div>
				<div class="col-1 contentInsert">
					<a></a>
				</div>
			</div>
			
			<div class="row campo">
				<div class="col-1 contentInsert">
					<a></a>
				</div>
				<div class="col-1 contentField3 content">
					<a>Del</a>
				</div>
				<div class="col-1 contentField3 content">
					<input type="hidden" id="email" name="email" value="<%= request.getParameter("email") %>"/>
					<input type="submit" value="Send">
				</div>
				<div class="col-9 contentInsert">
					<a></a>
				</div>
			</div>
	
		</div>
	</form>
	
	<div class="container">
		<div class="row">
			<div class="col-3 content">
				<a></a>
			</div>
			<div class="col-3 contentHome content">
				<form action="/m8_servlets/jsp/Index2.jsp">
					<input type="hidden" id="email" name="email" value="<%= request.getParameter("email") %>"/>
					<input type="submit" value="Home">
				</form>
			</div>
			<div class="col-3 content">
				<a></a>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-11 contentFooter content">
				<a>Footer</a>
			</div>
		</div>
	</div>


</body>

</html></span>




