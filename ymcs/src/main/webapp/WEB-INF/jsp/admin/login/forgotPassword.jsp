<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"  scope="application"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IP</title>
    <!-- Custom CSS -->
    <link href="${contextPath}/static/css/main.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
		var ctx = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
	<div class='login_wrap'>
	<div class="login-holder">
	<div class="login">
			<img src="${contextPath}/static/images/jetprivilege_logo.png" alt="">
			<form:form autocomplete="off" id="forgotPassword" class="form-signin" >
				<h2>Forgot Password</h2>
				<c:if test="${fn:length(errorMsg) gt 0}"><div style="color:red;font-weight: bold;"  ><c:out value="${errorMsg}"></c:out></div> </c:if>
				<div class="admin">
					<label class=" control-label">Email ID</label>
					<input  type="text" name="userName" class="form-control "/>
				</div>
		
				<p>
					<span class="text-left">
						<a class="text-left" href="${contextPath}/">Cancel</a>
					</span>
					<span class="text-right">
						<a class="btn bg-b" onClick="$(this).closest('form').submit();" >Submit</a>
						
					</span>
				</p>
				
			</form:form>	
	</div><!---login-->
	</div>
	</div><!---login wrap-->
    <!-- jQuery -->
	<script src="${contextPath}/static/js/integrated.js"></script>
	<script type="text/javascript" src="${contextPath}/static/js/jquery.validate.min.js"></script>
</body>

<script type="text/javascript">
$(document).ready(function () {
	
	 /* for jquery validation*/
	 $("#forgotPassword").validate({
		 rules: {
			 userName:"required"
	        },
	        messages: {
	        	userName: "Please enter User Name/Email ID"
	        	
	        },
	        errorElement: "div",
	        submitHandler: function (form) {
	               form.submit();
	        } 
	 });

	 /* for submit the form on key press enter*/
	 $(document).keypress(function(event){
		    if(event.keyCode == 13){
			    $("#forgotPassword").submit();
		    }
		});
	
});
$(document).on("keydown", function (e) {
    if (e.which === 8 && !$(e.target).is("input, textarea")) {
        e.preventDefault();
    }
});

</script>
</html>