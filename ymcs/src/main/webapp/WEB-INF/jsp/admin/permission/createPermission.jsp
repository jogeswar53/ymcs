<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>Permission Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Permission Configuration</li>
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
	<!-- Model contents starts here  -->
		<div id="viewPermissionModel" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Permission Details</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class='col-md-6'>
								<label>Role Name</label>
								<p id="viewPermissionRoleName" ></p>
							</div>
							<div class='col-md-6'>
								<label>Menu Name</label>
								<p id="viewPermissionMenuName" ></p>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<label>Status</label>
								<p id="viewPermissionStatus" ></p>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<button class="bg_g_button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="deletePermissionModel" class="modal fade" role="dialog">
			<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Are You Sure?</h4>
				</div><!--header-->
				<div class="modal-body">
					<p>
						<img src="${contextPath}/static/img/info_icon1.png"></img>
						<span> Class will be deleted. Are you sure?</span> 
						<input type="hidden" id="delPermissionId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deletePermissionId" class="bg_g_button" data-dismiss="modal">Delete</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
	<!-- Model contents ends here  -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Create Permission</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewPermission" data-toggle="tab">View Permission</a></li>
								<li ><a href="#addPermission" data-toggle="tab">Add Permission</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewPermission">
									<div class="box-body responsive-table">
										<c:if test="${ not empty permissionList }">
											<table id="permission-table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Role Name</th>
														<th>Menu Names</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ permissionList }" var="permissionMaster" varStatus="i">
														<tr data-id="${ i.count }"
															data-roleid="${ permissionMaster.roleId }"
															data-rolename="${ permissionMaster.roleName }"
															data-menuname="${ permissionMaster.menuName }" >
															<td>${ i.count }</td>
															<td>${ permissionMaster.roleName }</td>
															<td>${ permissionMaster.menuName }</td>
															<td class="${ permissionMaster.activeStatusClass }">${ permissionMaster.activeStatusValue }</td>
															<td>
																<span class="viewPermission" data-target="#viewPermissionModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editPermission" data-target="#editPermissionModel">
																	<i class="fa fa-edit"></i>
																</span>
																<span class="deletePermission" data-target="#deletePermissionModel">
																	<i class="fa fa-trash"></i>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${ empty permissionList }">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane" id="addPermission">
									<form:form id="addPermissionForm" commandName="addPermissionForm">
										<input type="hidden" name="menuId" id="menuId">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Role Name</label><span class="mandatory_star">*</span>
														<form:select path="roleId" class="form-control select2">
															<form:option value="">Select Role</form:option>
															<form:options items="${roleMap}" />
														</form:select>
												</div>
											</div>
											<%-- <div class="col-md-4">
												<div class="form-group">
													<label>Select Menu</label><span class="mandatory_star">*</span>
														<form:select path="menuId" class="form-control select2" multiple="multiple">
															<form:options items="${menuMap}" />
														</form:select>
												</div>
											</div> --%>
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createPermission?pid=2&mid=11">Cancel</a> &nbsp;&nbsp;
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

<link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css" rel="stylesheet" type="text/css"/>
<script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js" type="text/javascript"></script>

<link rel="stylesheet" href="${contextPath}/static/css/plugins/jstree-3.0.1/themes/default/style.min.css">
<script src="${contextPath}/static/js/plugins/jstree.min.js"></script>

<script>
rradminportal.common();
var data = JSON.parse('${ MenuList }');
rradminportal.createPermission(data);
</script>