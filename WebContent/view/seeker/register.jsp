<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<title>Seeker Register</title>
</head>

<%@ include file="/view/layout/appHeader.html" %>

<body>

	<div class="container">
		<br> <br>
		<div class="panel-group">

			<div class="panel panel-primary">
				<div class="panel-heading">Seeker Registration</div>
				<div class="panel-body">
					<form action="create" method="post">
						<div class="row">
							
							<div class="col-md-6">
								<label for="usr">Password:</label>
								<input type="text" class="form-control" name="password" required="required">
							</div>
							<div class="col-md-6">
								<label for="usr">Name:</label>
								<input type="text" class="form-control" name="name" required="required">
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<label for="usr">Phone:</label>
								<input type="text" class="form-control" name="phone" required="required" maxlength="10">
							</div>
							<div class="col-md-6">
								<label for="usr">Email:</label>
								<input type="email" class="form-control" name="email" required="required">
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<label for="usr">Gender:</label>
								<input type="text" class="form-control" name="gender" required="required">
							</div>
							<div class="col-md-6">
								<label for="usr">Age:</label>
								<input type="text" class="form-control" name="age" required="required" maxlength="2">
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<label for="usr">City:</label>
								<input type="text" class="form-control" name="city" required="required">
							</div>
							<div class="col-md-6">
								<label for="usr">Blood Group:</label>
								<input type="text" class="form-control" name="blood_group" required="required" maxlength="2">
							</div>
						</div>
                      


						<div class="form-group">
							<label for="usr">State:</label>
							<input type="text" class="form-control" name="state" required="required">
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Register ">
							<a href="${pageContext.request.contextPath}/SeekerServlet/login"
								class="btn btn-primary">Already Registered</a>
							${message }
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>

<%@ include file="/view/layout/footer.html" %>


</html>