<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<title>TestApp</title>

		<!-- Custom CSS -->
		<!-- Select2 -->
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/select2.css">
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/jquery-ui.css">
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/bootstrap-datepicker.css">
		<!-- Bootstrap 3.3.7 -->
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/bootstrap/bootstrap.css">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/font-awesome/font-awesome.css">
		<!-- Ionicons -->
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/Ionicons/ionicons.css">
		<!-- Theme style -->
		<link rel="stylesheet" href="${contextPath}/static/css/testadmin.css">
		<!-- testApp Skins. Choose a skin from the css/skins
		folder instead of downloading all of them to reduce the load. -->
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/skins/_all-skins.css">
		<!-- DataTables -->
		<link rel="stylesheet" href="${contextPath}/static/css/plugins/datatables.net-bs/dataTables.bootstrap.css">
		<!-- Google Font -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

		<link rel="stylesheet" href="${contextPath}/static/css/scss/testportal.css">

		<script>
			var ctx = "${pageContext.request.contextPath}";
		</script>

		<script src="${contextPath}/static/js/integrated.js"></script>
		<script src="${contextPath}/static/js/adminlte.js"></script>
		<script src="${contextPath}/static/js/testadminlte.js"></script>
		<script src="${contextPath}/static/js/rradminportal.js"></script>
	</head>

	<body class="hold-transition skin-blue sidebar-mini">
		<div class='wrapper'>
			<header>
				<tiles:insertAttribute name="header" />
			</header>
			<tiles:insertAttribute name="body" />
			<footer id="footer">
				<tiles:insertAttribute name="footer" />
			</footer>
		</div>
	</body>
</html>
