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
<title>Event Information</title>
</head>
<body style="background-color: lavendar;overflow: hidden" >
<jsp:include page="header.jsp" />
<div class="container">
<table class="table table-responsive">
    <thead>
      <tr class="active">
        <th>Event Name</th>
        <th>Event Date</th>
        <th>Event Location</th>
        <th>Event Info</th>
        <th>Registration Link</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Serving</td>
        <td>12/02/2016</td>
        <td>Bangalore</td>
        <td>Serving lunch</td>
        <td><a href="registration.jsp">Click to Register</a></td>
      </tr>
      <tr>
        <td>Serving</td>
        <td>12/02/2016</td>
        <td>Bangalore</td>
        <td>Serving lunch</td>
         <td><a href="registration.jsp">Click to Register</a></td>
      </tr>
      <tr>
        <td>Serving</td>
        <td>12/02/2016</td>
        <td>Bangalore</td>
        <td>Serving lunch</td>
         <td><a href="registration.jsp">Click to Register</a></td>
      </tr>
      </tbody>
  </table>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>