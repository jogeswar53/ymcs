<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>Class Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Class Configuration</li>
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
		<div id="viewClassModel" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Class Details</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class='col-md-6'>
								<label>Class Code</label>
								<p id="viewClassCode" ></p>
							</div>
							<div class='col-md-6'>
								<label>Class Name</label>
								<p id="viewClassName" ></p>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<label>Status</label>
								<p id="viewClassStatus" ></p>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<button class="bg_g_button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="deleteClassModel" class="modal fade" role="dialog">
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
						<input type="hidden" id="delClassId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteClassId" class="bg_g_button" data-dismiss="modal">Delete</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
	<!-- Model contents ends here  -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Create Class</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewClass" data-toggle="tab">View Classes</a></li>
								<li ><a href="#addClass" data-toggle="tab">Add Class</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewClass">
									<div class="box-body responsive-table">
										<c:if test="${ not empty classList }">
											<table id="class_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Class Code</th>
														<th>Class Name</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ classList }" var="classMaster" varStatus="i">
														<tr data-id="${ i.count }"
															data-classcode="${ classMaster.classCode }"
															data-classname="${ classMaster.className }" >
															<td>${ i.count }</td>
															<td>${ classMaster.classCode }</td>
															<td>${ classMaster.className }</td>
															<td class="${ classMaster.activeStatusClass }">${ classMaster.activeStatusValue }</td>
															<td>
																<span class="viewClass" data-target="#viewClassModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editClass">
																	<a href="${contextPath}/admin/updateClass?classId=${ classMaster.classId }&pid=2&mid=7"><i class="fa fa-edit"></i></a>
																</span>
																<span class="deleteClass" data-target="#deleteClassModel">
																	<i class="fa fa-trash"></i>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${ empty classList }">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane" id="addClass">
									<form:form id="addClassForm" commandName="addClassForm">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Class Code</label><span class="mandatory_star">*</span>
													<form:input type="text" id="classCode" path="classCode" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Class Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="className" path="className" class="form-control" />
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createClass?pid=2&mid=7">Cancel</a> &nbsp;&nbsp;
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

<script>
changeURL('admin/createClass?pid=2&mid=7');
rradminportal.common();
rradminportal.classMaster();
</script>