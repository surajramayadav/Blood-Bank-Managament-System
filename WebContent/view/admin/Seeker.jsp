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
  <title> Seeker List</title>



</head>

<%@ include file="/view/layout/header.jsp" %>

<body>

  <%

	System.out.println("GET IN JSP");
	System.out.println(session.getAttribute("srEmail"));
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revaled"); 
		if(session.getAttribute("adEmail") == null && session.getAttribute("hoEmail") == null){
			response.sendRedirect("http://localhost:9090/BloodBank/AdminServlet/login");
		}
	%>


  <div class="container">
    <br> <br> <br>
    <h3>Welcome ${adEmail} .</h3>
    <div class="panel-group">

      <div class="panel panel-primary">
        <div class="panel-heading">Seeker List</div>
        <div class="panel-body table-responsive">
       <table class="table table-bordered">
            <thead>
              <tr>
                
                <th>Id</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Gender</th>

                <th>Age</th>
                <th>Blood Group</th>
                <th>City</th>
                 <th>State</th>
                <th>Action</th>
                
              </tr>
            </thead>

            <tbody>
              <c:forEach items="${list}" var="seeker">
                <tr>
              
              <td>${seeker.sid}</td>
                  <td>${seeker.name}</td>
                  <td>${seeker.phone}</td>
                  <td>${seeker.email}</td>
                  <td>${seeker.gender}</td>

                  <td>${seeker.age}</td>
                  <td>${seeker.blood_group}</td>
                   <td>${seeker.city}</td>
                    <td>${seeker.state}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/AdminServlet/Undo?sid=${seeker.sid}" class="btn btn-danger"> Delete</a></td>
                </tr>
              </c:forEach>
            </tbody>

          </table>
        
        </div>
      </div>
    </div>
  </div>


</body>

<%@ include file="/view/layout/footer.html" %>



</html>