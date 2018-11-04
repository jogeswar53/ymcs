<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>User Role Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">User Role Configuration</li>
		</ol>
		<c:if test="${fn:length(message) gt 0}">
			<div class="alertMessage success-message">
				<c:out value="${message}"></c:out>
			</div>
		</c:if>
		<c:if test="${fn:length(errormessage) gt 0}">
			<div class="alertMessage error-message">
				<c:out value="${errormessage}"></c:out>
			</div>
		</c:if>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Update User Role</div>
					<div class="panel-body">
						<div class="menu_tab">
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="addUserRole">
									<form:form id="addUserRoleForm" commandName="addUserRoleForm">
									<form:input type="hidden" id="menuId" path="menuId"/>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Role Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="userRoleName" path="roleName" class="form-control" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="panel panel-default">
													<div class="panel-heading">Menu List</div>
													<div class="panel-body permission-menu-body">
														<div class="menu_list"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Role Description</label><span class="mandatory_star">*</span>
													<form:textarea rows="5" type="text" id="userRoleDesc" path="roleDesc" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Status</label><span class="mandatory_star">*</span>
													<ul class="list-inline">
														<c:forEach items="${activeStatus}" var="status">
															<li>
																<label>
																	<form:radiobutton path="activeStatus" class="css-checkbox" id="${status.key}" value="${status.key}" />
																	<label for="${status.key}" class="css-label radGroup2">${status.value}</label>
																</label>
															</li>
														</c:forEach>
													</ul>
												</div>
											</div>
										</div>
										<div class="row ">
											<div class="col-md-8 text-center pull-right">
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createUserRole?pid=2&mid=12">Cancel</a> &nbsp;&nbsp;
												<a class="btn navbar-btn btn-primary" onclick="$(this).closest('form').submit();">Save</a>
											</div>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<link rel="stylesheet" href="${contextPath}/static/css/plugins/jstree-3.0.1/themes/default/style.min.css">
<script src="${contextPath}/static/js/plugins/jstree.min.js"></script>

<script>
rradminportal.common();
var data = JSON.parse('${ MenuList }');
rradminportal.createRole(data);
</script>