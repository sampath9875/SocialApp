<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
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
<script type = "text/javascript" 
         src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<title>Registration</title>
<script type="text/javascript">
jQuery(document).ready(function(){
	$('#location').change(function (){
		var optionSelected=$("option:selected",this);
		var val=this.value;
		ajaxLoad(val);
	});
});
function ajaxLoad(location)
{
$.ajax({
	type : "get",
	contentType : "application/text",
	url : "getEvents",
	data : {"location" : location},
	success: function (data)
	{
		var json = JSON.stringify(eval("(" + data + ")"));
		var data1=JSON.parse(json);
		$.each(data1, function(key, value) {   
		     $('#eventName')
		         .append($("<option></option>")
		                    .attr("value",key)
		                    .text(value)); 
		});
	},
	error : function(){
		alert("fail");
	},
	done : function() {
		alert("done");
	}
});
}
/* var xmlHttp;
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
} */
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
<form:input type="text" id="phone" class="form-control" path="volunteerPhoneno" />
<form:errors path="volunteerPhoneno" class="control label" />
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
<label class="col-sm-2" for="location">Select Location</label>
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
<label class="col-sm-2" for="eventName">Select event</label>
<div class="col-sm-5">
<form:select path="event.eventName" id="eventName" class="form-control" placeHolder="select">
<form:option value="select">Select event..</form:option>
<%-- <jstl:forEach items="${events}" var="events1">
<form:option value="${events1.eventId}">${events1.eventName} - ${events1.eventName}</form:option>
</jstl:forEach> --%>
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
=======
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
>>>>>>> branch 'FirstBranch' of https://github.com/sampath9875/SocialApp
</body>
</html>