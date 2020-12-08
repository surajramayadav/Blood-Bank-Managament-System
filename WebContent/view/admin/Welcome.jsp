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
  <title> Admin Report</title>

<style>
.card-counter{
    box-shadow: 2px 2px 10px #DADADA;
    margin: 5px;
    padding: 20px 10px;
    background-color: #fff;
    height: 100px;
    border-radius: 5px;
    transition: .3s linear all;
  }

  .card-counter:hover{
    box-shadow: 4px 4px 20px #DADADA;
    transition: .3s linear all;
  }

  .card-counter.primary{
    background-color: #007bff;
    color: #FFF;
  }

  .card-counter.danger{
    background-color: #ef5350;
    color: #FFF;
  }  

  .card-counter.success{
    background-color: #66bb6a;
    color: #FFF;
  }  

  .card-counter.info{
    background-color: #26c6da;
    color: #FFF;
  }  

  .card-counter i{
    font-size: 5em;
    opacity: 0.2;
  }

  .card-counter .count-numbers{
    position: absolute;
    right: 35px;
    top: 20px;
    font-size: 32px;
    display: block;
  }

  .card-counter .count-name{
    position: absolute;
    right: 35px;
    top: 65px;
    font-style: italic;
    text-transform: capitalize;
    opacity: 0.5;
    display: block;
    font-size: 18px;
  }</style>




</head>

<%@ include file="/view/layout/header.jsp" %>

<body>

  <%

	System.out.println("GET IN JSP");
	System.out.println(session.getAttribute("drEmail"));
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revaled"); 
		if(session.getAttribute("adEmail") == null && session.getAttribute("hoEmail") == null){
			response.sendRedirect("http://localhost:9090/BloodBank/DonorServlet/login");
		}
	%>

<br> <br><br> <br>
<div class="container">
 <div class="row">
    <div class="col-md-4">
      <div class="card-counter primary">
        <i class="fa fa-code-fork"></i>
        <span class="count-numbers">Reports  :</span>
         
      </div>
    </div>
 
    </div>

  
  <br> <br><br> <br> 
    <div class="row">
    <div class="col-md-4">
      <div class="card-counter primary">
        <i class="fa fa-code-fork"></i>
        <span class="count-numbers">${donor}</span>
        <span class="count-name">Donor </span>
      </div>
    </div>
 
    <div class="col-md-4">
      <div class="card-counter success">
        <i class="fa fa-database"></i>
        <span class="count-numbers">${seeker }</span>
        <span class="count-name">Seeker</span>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card-counter info">
        <i class="fa fa-users"></i>
        <span class="count-numbers">${rr}</span>
        <span class="count-name">Request</span>
      </div>
    </div>
  </div>
  <br> <br><br> <br> 
  
</div>


</body>

<%@ include file="/view/layout/footer.html" %>



</html>