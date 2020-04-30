<span style="color: #000000;"><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="description" content="Exemple pàgina">
	<meta name="keywords" content="HTML,CSS,XML,JavaScript">
	<meta name="author" content="Eric Floro">

	<title>Success - Eric Floro</title>

	<link href="Success/css/style.css" rel="stylesheet">
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
			<div class="col-11 contentTitle content">
				<h1>Success</h1>
			</div>
		</div>
	</div>

	<div class="container campos">
		<div class="row campo">
			<div class="col-11 contentField content">
				<a> Product for ${param.email} saved correctly! <br>:-)</a>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-3 content">
				<a></a>
			</div>
			<div class="col-3 contentHome content">
				<form action="jsp/Index2.jsp">
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
