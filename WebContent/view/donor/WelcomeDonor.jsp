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
  <title> Donor</title>



</head>

<%@ include file="/view/layout/header.jsp" %>

<body>

  <%

	System.out.println("GET IN JSP");
	System.out.println(session.getAttribute("drEmail"));
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revaled"); 
		if(session.getAttribute("drEmail") == null && session.getAttribute("hoEmail") == null){
			response.sendRedirect("http://localhost:9090/BloodBank/DonorServlet/login");
		}
	%>


  <div class="container">
    <br> <br> <br>
    <h3>Welcome ${drEmail} .</h3>
    <div class="panel-group">

      <div class="panel panel-primary">
        <div class="panel-heading">Seeker Requested List</div>
        <div class="panel-body table-responsive">
       <table class="table table-bordered">
            <thead>
              <tr>
               
              
               <th>Id</th>
                <th>Sid</th>
              <th>did</th>
                <th>status</th>
                <th>Request</th>
                
              </tr>
            </thead>

            <tbody>
             <c:forEach items="${list1}" var="Request">
                <tr>
                
                <td>${Request.id}</td>
                  <td>${Request.sid}</td>
                <td>${sessionScope.d_id}</td>
                  <td>${Request.status}</td>
                    <td> <a href="${pageContext.request.contextPath}/DonorServlet/request?id=${Request.id}" class="btn btn-primary"> Accept Request</a></td>
             </td>
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