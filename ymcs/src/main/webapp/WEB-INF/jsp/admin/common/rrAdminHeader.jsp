<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="now" value="<%=new java.util.Date()%>" />

<header class="main-header">
	<!-- Logo -->
	<a href="${contextPath}/admin/dashboard?pid=0&mid=1" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>T</b>Factor</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>YM</b>CS</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="push-menu"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Notifications: style can be found in dropdown.less -->
				<li class="dropdown notifications-menu">
					<ul class="dropdown-menu">
						<li class="header">You have 10 notifications</li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li><a href="#"> <i class="fa fa-users text-aqua"></i>
										5 new members joined today
								</a></li>
								<li><a href="#"> <i class="fa fa-warning text-yellow"></i>
										Very long description here that may not fit into the page and
										may cause design problems
								</a></li>
								<li><a href="#"> <i class="fa fa-users text-red"></i> 5
										new members joined
								</a></li>
								<li><a href="#"> <i
										class="fa fa-shopping-cart text-green"></i> 25 sales made
								</a></li>
								<li><a href="#"> <i class="fa fa-user text-red"></i>
										You changed your username
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul></li>
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img src="${contextPath}/admin/images/${sessionScope.activeUser.profileImg}" class="user-image" alt="User Image">
						<span class="hidden-xs">${sessionScope.activeUser.firstName}&nbsp;${sessionScope.activeUser.lastName}</span>
					</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header">
							<img src="${contextPath}/admin/images/${sessionScope.activeUser.profileImg}" class="img-circle" alt="User Image">
							<p>${sessionScope.activeUser.firstName}&nbsp;${sessionScope.activeUser.lastName}
							 - ${sessionScope.activeUser.userType} <small>Member since ${sessionScope.activeUser.createdTime}</small></p>
						</li>
						<!-- Menu Body -->
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="${contextPath}/admin/logout" class="btn btn-default btn-flat">Sign out</a>
							</div>
						</li>
					</ul></li>
				<!-- Control Sidebar Toggle Button -->
			</ul>
		</div>
	</nav>
</header>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${contextPath}/admin/images/${sessionScope.activeUser.profileImg}" class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${sessionScope.activeUser.firstName}&nbsp;${sessionScope.activeUser.lastName}</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- sidebar menu: : style can be found in sidebar.less -->
			<c:out value="${menuList}" escapeXml="false"/>
	</section>
	<!-- /.sidebar -->
</aside>
