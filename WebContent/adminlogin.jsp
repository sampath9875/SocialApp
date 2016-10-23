<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=100%, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<title>Login</title>
</head>
<body style="background-color: lavendar;overflow: hidden" >
<jsp:include page="header.jsp" />
<div class="container">
<div class="row">
<div class="col-md-5">
<div class="jumbotron">
<h4>Admin Registration</h4>
<p>Make technology to help alwaysMake technology to help alwaysMake technology to help alwaysMake technology to help always</p>
<a href="adminsignup.jsp" class="btn btn-primary">Admin Registration</a>
</div>
</div>
<div class="col-md-1"></div>
<div class="col-md-5">
<div class="jumbotron">
<form>
<h4>Admin Login</h4>
<div class="form-group">
<label for="name">Enter your User Name</label>
<input type="text" id="name" class="form-control">
</div>
<div class="form-group">
<label for="phone">Enter your password</label>
<input type="password" id="phone" class="form-control">
</div>
<div class="form-group">
<input type="submit" id="submit" class="form-control btn btn-primary" value="Login">
</div>
</form>
</div>
</div>
<div class="col-md-1"></div>
</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>