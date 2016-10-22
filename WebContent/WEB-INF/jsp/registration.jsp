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
<title>Registration</title>
</head>
<body style="background-color: lavendar">
<div class="container.fluid">
<div class="row" style="background-color: #B0C4DE"><center><h2>Application name</h2></center></div>
<form class="form-horizontal">
<div class="form-group">
<div class="col-sm-1"></div>
<div class="col-sm-2"><h4>Register Here</h4></div>
<div class="col-sm-8"></div>
</div>
<div>
<div class="form-group">
<div class="col-sm-1"></div>
<label class="col-sm-2" for="name">Please enter your name</label>
<div class="col-sm-1">:-</div>
<div class="col-sm-5">
<input type="text" id="name" class="form-control">
</div>
<div class="col-sm-1"></div>
</div>
<div class="form-group">
<div class="col-sm-1"></div>
<label class="col-sm-2" for="email">Please enter your email</label>
<div class="col-sm-1">:-</div>
<div class="col-sm-5">
<input type="email" id="email" class="form-control">
</div>
<div class="col-sm-1"></div>
</div>
<div class="form-group">
<div class="col-sm-1"></div>
<label class="col-sm-2" for="phone">Please enter your phone number</label>
<div class="col-sm-1">:-</div>
<div class="col-sm-5">
<input type="text" id="phone" class="form-control">
</div>
<div class="col-sm-1"></div>
</div>
</div>
<div class="form-group">
<div class="col-sm-1"></div>
<label class="col-sm-3" ></label>
<div class="col-sm-5">
<input type="submit" id="submit" class="form-control" value="Register" style="background-color: #B0C4DE">
</div>
<div class="col-sm-1"></div>
</div>
</form>
</div>
</body>
</html>