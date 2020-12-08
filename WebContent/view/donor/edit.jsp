<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<title>Donor Profile</title>
</head>

<%@ include file="/view/layout/header.jsp" %>

<body>
<%

	System.out.println("GET IN JSP");
	System.out.println(session.getAttribute("drEmail"));
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revaled"); 
		if(session.getAttribute("drEmail") == null && session.getAttribute("hoEmail") == null){
			response.sendRedirect("DonorServlet/login");
		}
	%>

	<div class="container">
		<br> <br>
		<div class="panel-group">

			<div class="panel panel-primary">
				<div class="panel-heading">Donor Profile </div>
				<div class="panel-body">
					<form action="edit" method="post">
						<div class="row">
							 <c:forEach items="${list}" var="donor">
							<div class="col-md-6">
								<label for="usr">Password:</label>
								<input type="text" class="form-control" name="password" value="${donor.password}">
							</div>
							<div class="col-md-6">
								<label for="usr">Name:</label>
								<input type="text" class="form-control" name="name" value="${donor.name}">
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<label for="usr">Phone:</label>
								<input type="text" class="form-control" name="phone" value="${donor.phone}">
							</div>
							<div class="col-md-6">
								<label for="usr">Email:</label>
								<input type="text" class="form-control" name="email" value="${donor.email}">
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<label for="usr">Gender:</label>
								<input type="text" class="form-control" name="gender" value="${donor.gender}">
							</div>
							<div class="col-md-6">
								<label for="usr">Age:</label>
								<input type="text" class="form-control" name="age" value="${donor.age}">
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<label for="usr">City:</label>
								<input type="text" class="form-control" name="city" value="${donor.city}">
							</div>
							<div class="col-md-6">
								<label for="usr">Blood Group:</label>
								<input type="text" class="form-control" name="blood_group" value="${donor.blood_group}">
							</div>
						</div>
                      


						<div class="form-group">
							<label for="usr">State:</label>
							<input type="text" class="form-control" name="state" value="${donor.state}">
						</div>
						    </c:forEach>
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Update ">
							
					
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>

<%@ include file="/view/layout/footer.html" %>


</html>