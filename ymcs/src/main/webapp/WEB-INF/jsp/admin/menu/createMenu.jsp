<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>
			Home <small>Menu Configuration</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Menu Configuration</li>
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
		<div id="deleteMenuModel" class="modal fade" role="dialog">	
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
						<span> Menu will be deleted. Are you sure?</span> 
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteMenuId" class="bg_g_button" data-dismiss="modal">Delete</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-default">
					<div class="panel-heading">Menu List</div>
					<div class="panel-body">
						<div class="menu_list"></div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">Add Menu</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active" id="homeTab"><a href="#home" data-toggle="tab">View Menu</a></li>
								<li id="addMenuTab"><a href="#addMenu" data-toggle="tab">Add Menu</a></li>
								<li id="addSubMenuTab"><a href="#addSubMenu" data-toggle="tab">Add Sub Menu</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="home">
									<div class="row">
										<div class="col-md-3">
											<div class="form-group">
												<label>ID</label>
												<p id="menuId"></p>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label>Name</label>
												<p id="menuName"></p>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label>Status</label>
												<p id="menuStatus"></p>
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane" id="addMenu">
									<form:form id="addMenuForm" commandName="addMenuForm">
									<form:input path="action" id="actionId" type="hidden" value="addMenu" />
									<form:input path="menuId" id="menuIdHidden" type="hidden" />
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Name</label><span class="mandatory_star">*</span>
													<form:input type="text" path="menuName" id="menuNameId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Descriptions</label><span class="mandatory_star">*</span>
													<form:input type="text" path="menuDesc" id="menuDescId" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>URL</label><span class="mandatory_star">*</span>
													<form:input type="text" path="menuUrl" id="menuUrlId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Icon URL</label><span class="mandatory_star">*</span>
													<form:input type="text" path="iconUrl" id="iconUrlId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createMenu?pid=2&mid=3">Cancel</a> &nbsp;&nbsp;
												<a id="saveMenu" class="btn navbar-btn btn-primary" onclick="$(this).closest('form').submit();">Save</a>
											</div>
										</div>
									</form:form>
								</div>
								<div class="tab-pane" id="addSubMenu">
									<form:form id="addSubMenuForm" commandName="addSubMenuForm">
										<form:input id="parentMenuLevel" path="parentMenuLevel" type="hidden" />
										<form:input path="action" type="hidden" value="addSubMenu" />
										<form:input path="menuId" type="hidden" />
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Parent Name</label><span class="mandatory_star">*</span>
													<input id="parentName" type="text" class="form-control" disabled="disabled" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Name</label><span class="mandatory_star">*</span>
													<form:input path="menuName" type="text" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Descriptions</label><span class="mandatory_star">*</span>
													<form:input path="menuDesc" type="text" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>URL</label><span class="mandatory_star">*</span>
													<form:input path="menuUrl" type="text" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Icon URL</label><span class="mandatory_star">*</span>
													<form:input path="iconUrl" type="text" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createMenu?pid=2&mid=3">Cancel</a> &nbsp;&nbsp;
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
	//changeURL('admin/createMenu?pid=2&mid=3');
	rradminportal.common();
	var data = JSON.parse('${ MenuList }');
	rradminportal.menu(data);

	setTimeout(function () {
		getSelectedTreeValue();
	}, 800);

	function getSelectedTreeValue() {
		var id = $('.menu_list').jstree().get_selected(true)[0].id;
		var text = $('.menu_list').jstree().get_selected(true)[0].text;

		$("#menuId").html(id);
		$("#menuName").html(text);
		$("#parentName").val(text);
		$("#parentMenuLevel").val(id);

		$("#menuStatus").html($('.menu_list .jstree-clicked').attr("statusvalue"));
		$("#menuStatus").addClass($('.menu_list .jstree-clicked').attr("statusclass"));
	}
</script>