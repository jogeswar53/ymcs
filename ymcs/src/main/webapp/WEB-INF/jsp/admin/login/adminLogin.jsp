<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

	<link rel="shortcut icon" href="${contextPath}/static/img/favicon.png" type="image/x-icon">
	<link rel="icon" href="${contextPath}/static/img/favicon.png" type="image/x-icon">

	<title>Login Please | Log in</title>

<style type="text/css">
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 300px;
  margin: 0 auto 100px;
  padding: 30px;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  border-bottom-left-radius: 3px;
  border-bottom-right-radius: 3px;
  text-align: center;
  
}
.form .thumbnail {
  background: #177eaf;
  width: 150px;
  height: 150px;
  margin: 0 auto 30px;
  padding: 50px 30px;
  border-top-left-radius: 100%;
  border-top-right-radius: 100%;
  border-bottom-left-radius: 100%;
  border-bottom-right-radius: 100%;
  box-sizing: border-box;
}
.form .thumbnail img {
  display: block;
  width: 100%;
}
.form input {
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  border-bottom-left-radius: 3px;
  border-bottom-right-radius: 3px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  outline: 0;
  background: #EF3B3A;
  width: 100%;
  border: 0;
  padding: 15px;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  border-bottom-left-radius: 3px;
  border-bottom-right-radius: 3px;
  color: #FFFFFF;
  font-size: 14px;
  transition: all 0.3 ease;
  cursor: pointer;
}
.login-buttons {
  outline: 0;
  background: #EF3B3A;
  width: 94%;
  border: 0;
  padding: 10px;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  border-bottom-left-radius: 3px;
  border-bottom-right-radius: 3px;
  color: #FFFFFF;
  font-size: 14px;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 13px;
}
.form .message a {
  color: #EF3B3A;
  text-decoration: none;
}
.form .register-form {
  display: none;
}

.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}

body {
  background: #ccc;
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
body:before {
  content: "";
  position: fixed;
  top: 0;
  left: 0;
  display: block;
  background: url(static/img/sativa.png) repeat fixed;
  width: 100%;
  height: 100%;
}
.error{
	color: red;
	font-size: 14px;
    margin-top: -14px;
    margin-bottom: 15px;
    text-align: left;
}
</style>

	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
	<link rel='stylesheet prefetch' href='${contextPath}/static/css/plugins/font-awesome/font-awesome.css'>

	<script>
		var ctx = "${pageContext.request.contextPath}";
	</script>

</head>

<body class="hold-transition login-page">
	<div class="container">
		<div class="info">
			<h1>Login Please</h1><span>Powered <i class="fa fa-heart"></i> by <a href="javascript:void(0);">Yolimart</a></span>
		</div>
	</div>
	<div class="form">
		<div class="thumbnail"><a href="${contextPath}/admin/login"><img src="${contextPath}/static/img/camera.jpeg"/></a></div>
		<c:if test="${fn:length(errorMsg) gt 0}">
			<div class="error">
				<c:out value="${errorMsg}" />
			</div>
		</c:if>
		<form:form autocomplete="off" id="adminUserBean" class="login-form" commandName="adminUserBean">
			<div>
				<form:input path="userName" class="form-control " placeholder="Email"/>
			</div>
			<div>
				<form:password path="password" class="form-control " placeholder="Password"/>
			</div>
			<div  class="login-buttons">
				<a class="btn btn-primary btn-block btn-flat " onClick="$(this).closest('form').submit();">Login</a>
			</div>
			<p class="message"><a href="#">Forgot Password?</a></p>
		</form:form>
	</div>
	<script src="${contextPath}/static/js/integrated.js"></script>
	<script type="text/javascript" src="${contextPath}/static/js/plugins/jquery.validate.min.js"></script>
	<script src="${contextPath}/static/js/plugins/additional-methods.min.js"></script>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$.validator.addMethod('passwordChecking', function(value, element) {
			return this.optional(element)
					|| /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{8,15}$/
							.test(value);
		});

		/* for jquery validation*/
		$("#adminUserBean").validate({
			rules : {
				userName : "required",
				password : {
					required : true,
				// passwordChecking:true
				},
			},
			messages : {
				userName : "Please enter User Name/Email ID",
				password : {
					required : "Please enter password",
				//passwordChecking : 'Minimum 8 and Maximum 15 characters at least 1 Uppercase Alphabet,
				// 1 Lowercase Alphabet, 1 Number and 1 Special Character:'
				}
			},
			errorElement : "div",
			submitHandler : function(form) {
				form.submit();
			}
		});

		/* for submit the form on key press enter*/
		$(document).keypress(function(event) {
			if (event.keyCode == 13) {
				$("#adminUserBean").submit();
			}
		});
	});
</script>
</html>
