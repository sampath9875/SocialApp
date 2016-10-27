<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=100%, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<title>Registration</title>
<script type="text/javascript">
	function validate() {
		var name = document.getElementById("name").value;
		var phone = document.getElementById("phone").value;
		var email = document.getElementById("email").value;
		var location = document.getElementById("location").value;
		var event = document.getElementById("eventName").value;

		var emailCheck = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
		var nameCheck = /[a-zA-Z ]{3,20}$/;
		var phoneCheck = /^[9,8,7][0-9]{9}$/;

		if (name == "") {
			//alert("Please Enter Name");
			name.innerHTML="Please Enter a name";
			document.getElementById("name").focus();
			return false;
		} else if (!nameCheck.test(name)) {
			alert("please enter only characters in name");
			document.getElementById("name").value = "";
			document.getElementById("name").focus();
			return false;
		} else if (email == "") {
			alert("please enter email");
			document.getElementById("email").focus();
			return false;
		} else if (!emailCheck.test(email)) {
			alert("please enter valid email");
			document.getElementById("email").value = "";
			document.getElementById("email").focus();
			return false;
		} else if (phone == "") {
			alert("please enter phone number");
			document.getElementById("phone").focus();
			return false;
		} else if (!phoneCheck.test(phone)) {
			alert("please enter valid phone number");
			document.getElementById("phone").value = "";
			document.getElementById("phone").focus();
			return false;
		} else if (location == "select") {
			alert("please select location");
			document.getElementById("location").focus();
			return false;
		} else if (event == "0") {
			alert("please Select Event");
			document.getElementById("eventName").focus();
			return false;
		} else {
			return true;
		}
	}
	jQuery(document).ready(function() {
		$('#location').change(function() {
			var optionSelected = $("option:selected", this);
			var val = this.value;
			$('#eventName').empty();
			ajaxLoad(val);
		});
	});
	function ajaxLoad(location) {
		$.ajax({
			type : "get",
			contentType : "application/text",
			url : "getEvents",
			data : {
				"location" : location
			},
			success : function(data) {
				var json = JSON.stringify(eval("(" + data + ")"));
				var data1 = JSON.parse(json);
				$('#eventName').append(
						$("<option></option>").attr("value", 0).text(
								"Select Event..."));
				$.each(data1, function(key, value) {
					$('#eventName').append(
							$("<option></option>").attr("value", key).text(
									value));
				});
			},
			error : function() {
				alert("fail");
			},
			done : function() {
				alert("done");
			}
		});
	}
	function init() {
		document.getElementById("name").value = "";
		document.getElementById("phone").value = "";
		document.getElementById("email").value = "";
		document.getElementById("location").value = "select";
		document.getElementById("eventName").value = "select";
	}

	//window.onload = init;
</script>
</head>
<body style="background-color: lavendar; overflow: hidden"
	onload="init()">
	<jsp:include page="header.jsp" />
	<form:form id="registration" onsubmit="return validate();"
		class="form-horizontal" method="post" action="register.action"
		commandName="volunteer">
		<div class="container">
			<div class="jumbotron">
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-3">
							<h4>Register Here</h4>
						</div>
						<div class="col-sm-7"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2"></div>
						<label class="col-sm-2" for="name">Enter your name</label>
						<div class="col-sm-5">
							<form:input type="text" id="name" class="form-control"
								path="volunteerName" />
							<form:errors path="volunteerName" class="control label" />
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2"></div>
						<label class="col-sm-2" for="email">Enter your email</label>
						<div class="col-sm-5">
							<form:input type="email" id="email" class="form-control"
								path="volunteerEmail" />
							<form:errors path="volunteerEmail" class="control label" />
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2"></div>
						<label class="col-sm-2" for="phone">Enter your phone
							number</label>
						<div class="col-sm-5">
							<form:input type="text" id="phone" class="form-control"
								path="volunteerPhoneno" />
							<form:errors path="volunteerPhoneno" class="control label" />
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2"></div>
						<label class="col-sm-2" for="location">Select Location</label>
						<div class="col-sm-5">
							<form:select path="event.location.locationId" id="location"
								class="form-control" onchange="display(this.value)">
								<form:option value="select">Select location..</form:option>
								<jstl:forEach items="${locations}" var="location">
									<form:option value="${location.locationId}"> ${location.locationDetails} </form:option>
								</jstl:forEach>
							</form:select>
							<form:errors path="event.location.locationId" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2"></div>
						<label class="col-sm-2" for="eventName">Select event</label>
						<div class="col-sm-5">
							<form:select path="event.eventId" id="eventName"
								class="form-control">
								<form:option value="select">Select Event..</form:option>
								<%-- <jstl:forEach items="${events}" var="events1">
<form:option value="${events1.eventId}">${events1.eventName} - ${events1.eventName}</form:option>
</jstl:forEach> --%>
							</form:select>
							<form:errors path="event.eventId" cssClass="error"></form:errors>
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2"></div>
						<label class="col-sm-2"></label>
						<div class="col-sm-5">
							<input type="submit" id="submit"
								class="form-control btn btn-primary" value="Register">
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<jsp:include page="footer.jsp" />
</body>
</html>