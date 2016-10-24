<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript">
var xmlHttp;
function display(location)
{
if(!location.equals("select"))
var url="getEvents?location="+location;
if(window.XMLHttpRequest)
	{
	xmlHttp=new XMLHttpRequest();
	}
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
	xmlHttp.onreadystatechange=function (){
		if(xmlHttp.readyState==4&& xmlHttp.status==200)
			{
			var res=xmlHttp.responseText;
			document.getElementById("div1").innerHTML=res;
			}
	}
}
</script>
</head>
<body style="background-color: lavendar;overflow: hidden" >
<jsp:include page="header.jsp" />
<form:form class="form-horizontal" method="post" action="register.action" commandName="volunteer">
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
<form:input type="text" id="name" class="form-control" path="volunteerName" />
<form:errors path="volunteerName" class="control label" />
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="email">Enter your email</label>
<div class="col-sm-5">
<form:input type="email" id="email" class="form-control" path="volunteerName" />
<form:errors path="volunteerName" class="control label" />
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="phone">Enter your phone number</label>
<div class="col-sm-5">
<form:input type="text" id="location" onchange="display(this.value)" class="form-control" path="event.location.locationDetails" />
<form:errors path="event.location.locationDetails" class="control label" />
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="phone">Enter your phone number</label>
<div class="col-sm-5">
<form:input type="email" id="email" class="form-control" path="volunteerPhoneno" />
<form:errors path="volunteerPhoneno" class="control label" />
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="phone">Select Location</label>
<div class="col-sm-5">
<form:select path="event.location.locationDetails" id="location" class="form-control" onchange="display(this.value)">
<form:option value="select">Select location..</form:option>
<jstl:forEach items="${locations}" var="location">
<form:option value="${location.locationId}"> ${location.locationDetails} </form:option>
</jstl:forEach>
</form:select>
<form:errors path="event.location.locationDetails" cssClass="error"></form:errors>
</div>
<div class="col-sm-3"></div>
</div></div>
<div class="form-group">
<div class="row">
<div class="col-sm-2"></div>
<label class="col-sm-2" for="phone">Select event</label>
<div class="col-sm-5">
<form:select path="event.eventName" id="eventName" class="form-control">
<form:option value="select">Select event..</form:option>
<jstl:forEach items="${events}" var="events1">
<form:option value="${events1.eventId}">${events1.eventName} - ${events1.eventName}</form:option>
</jstl:forEach>
</form:select>
<form:errors path="event.eventName" cssClass="error"></form:errors>
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
</form:form>
<jsp:include page="footer.jsp" />
</body>
</html>