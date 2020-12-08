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
  <title>Donor Login</title>
</head>
<%@ include file="/view/layout/appHeader.html" %>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>



  <div class="container">
    <br> <br> <br> <br> <br>
    <div class="row">
      <div class="col-md-3">
      </div>
      <div class="col-md-6">

      </div>
      <div class="col-md-3">
      </div>
    </div>

    <div class="row">
      <div class="col-md-3">
      </div>
      <div class="col-md-6">
        <div class="panel-group">

          <div class="panel panel-primary">
            <div class="panel-heading">
              <center>
                <h4> Admin Login</h4>
              </center>
            </div>
            <div class="panel-body">
              <form action="login" method="post">
                <div class="form-group">
                  <label for="usr">Email:</label>
                  <input type="text" class="form-control" name="email">
                </div>
                <div class="form-group">
                  <label for="usr">Password:</label>
                  <input type="text" class="form-control" name="password">
                </div>
                <div class="form-group">
                  <input type="submit" class="btn btn-primary" value="Login">
               ${message }
              
                <div class="row">
                  <br/>
                  <div class="col-md-4">
                     <a href="${pageContext.request.contextPath}/DonorServlet/login" class="">Donor Login</a>
                  </div>
                  <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/SeekerServlet/login" class="">Seeker Login</a>
                  </div>
                 
                   <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/AdminServlet/login" class="">Admin Login</a>
                  </div>
                 
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3">
    </div>
  </div>
</body>

<%@ include file="/view/layout/footer.html" %>
</html>