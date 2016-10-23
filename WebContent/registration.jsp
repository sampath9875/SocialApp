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
<title>Registration</title>
</head>
<body style="background-color: lavendar;overflow: hidden" >
<jsp:include page="header.jsp" />
<form class="form-horizontal">
<div class="container">
<div class="jumbotron">
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3"><h4>Register Here</h4></div>
<div class="col-sm-7"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="name">Enter your name</label>
<div class="col-sm-5">
<input type="text" id="name" class="form-control">
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="email">Enter your email</label>
<div class="col-sm-5">
<input type="email" id="email" class="form-control">
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="phone">Enter your phone number</label>
<div class="col-sm-5">
<input type="text" id="phone" class="form-control">
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="phone">Select date</label>
<div class="col-sm-5">
<div class="input-group date" data-provide="datepicker">
    <input type="text" class="form-control">
    <div class="input-group-addon">
        <span class="glyphicon glyphicon-th"></span>
    </div>
</div>
		<script type="text/javascript">
		var nowDate = new Date();
		var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
		$('.datepicker').datepicker({
			todayHighlight: 1
		});
        </script>
        </div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="phone">Select event</label>
<div class="col-sm-5">
<select class="form-control" id="event">
    <option>Select ...</option>
    <option>Option 1</option>
    <option>Option 2</option>
  </select>
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" ></label>
<div class="col-sm-5">
<input type="submit" id="submit" class="form-control btn btn-primary" value="Register">
</div>
<div class="col-sm-3"></div>
</div></div>
</div>
</div>
</form>
<jsp:include page="footer.jsp" />
</body>
</html>