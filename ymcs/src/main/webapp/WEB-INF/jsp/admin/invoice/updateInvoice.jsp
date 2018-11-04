<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>Hostel Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Hostel Configuration</li>
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
		<div id="viewHostelModel" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Hostel Details</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class='col-md-6'>
								<label>Hostel Code</label>
								<p id="viewHostelCode" ></p>
							</div>
							<div class='col-md-6'>
								<label>Hostel Name</label>
								<p id="viewHostelName" ></p>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<label>Status</label>
								<p id="viewHostelStatus" ></p>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<button class="bg_g_button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="editHostelModel" class="modal fade" role="dialog">
			<form:form id="editHostelForm" commandName="addHostelForm">
				<form:input type="hidden" path="action" value="updateHostel" />
				<form:input type="hidden" path="hostelId" id="editHostelId" />
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Update Hostel Details</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class='col-md-6'>
									<label>Hostel Code</label><span class="mandatory_star">*</span>
									<form:input type="text" id="editHostelCode" path="hostelCode" class="form-control" />
								</div>
								<div class='col-md-6'>
									<label>Hostel Name</label><span class="mandatory_star">*</span>
									<form:input type="text" id="editHostelName" path="hostelName" class="form-control" />
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
														<form:radiobutton path="editActiveStatus" class="css-checkbox" id="${status.key}" value="${status.key}" />
														<label for="${status.key}" class="css-label radGroup2">${status.value}</label>
													</label>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer align-center">
							<button class="bg_g_button" data-dismiss="modal">Close</button>
							<button class="bg_g_button" onclick="$(this).closest('form').submit();">Update</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
		<div id="deleteHostelModel" class="modal fade" role="dialog">
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
						<span> Hostel will be deleted. Are you sure?</span> 
						<input type="hidden" id="delHostelId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteHostelId" class="bg_g_button" data-dismiss="modal">Delete</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
	<!-- Model contents ends here  -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Create Hostel</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewHostel" data-toggle="tab">View Hostels</a></li>
								<li ><a href="#addHostel" data-toggle="tab">Add Hostel</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewHostel">
									<div class="box-body responsive-table">
										<c:if test="${ not empty hostelList }">
											<table id="hostel_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Hostel Code</th>
														<th>Hostel Name</th>
														<th>Hostel Address</th>
														<th>Warden Name</th>
														<th>Warden Contact No</th>
														<th>Hostel Contact No</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ hostelList }" var="hostelMaster" varStatus="i">
														<tr data-id="${ i.count }"
															data-hostelcode="${ hostelMaster.hostelCode }"
															data-hostelid="${ hostelMaster.hostelId }"
															data-hostelname="${ hostelMaster.hostelName }" >
															<td>${ i.count }</td>
															<td>${ hostelMaster.hostelCode }</td>
															<td>${ hostelMaster.hostelName }</td>
															<td>${ hostelMaster.hostelAddress }</td>
															<td>${ hostelMaster.wardenName }</td>
															<td>${ hostelMaster.wardenContactNo }</td>
															<td>${ hostelMaster.hostelContactNo }</td>
															<td class="${ hostelMaster.activeStatusClass }">${ hostelMaster.activeStatusValue }</td>
															<td>
																<span class="viewHostel" data-target="#viewHostelModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editHostel" data-target="#editHostelModel">
																	<i class="fa fa-edit"></i>
																</span>
																<span class="deleteHostel" data-target="#deleteHostelModel">
																	<i class="fa fa-trash"></i>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${ empty hostelList }">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane" id="addHostel">
									<form:form id="addHostelForm" commandName="addHostelForm">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Hostel Code</label><span class="mandatory_star">*</span>
													<form:input type="text" id="hostelCode" path="hostelCode" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Hostel Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="hostelName" path="hostelName" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Hostel Address</label><span class="mandatory_star">*</span>
													<form:input type="text" id="hostelAddress" path="hostelAddress" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Warden Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="wardenName" path="wardenName" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Warden Contact No</label><span class="mandatory_star">*</span>
													<form:input type="text" id="wardenContactNo" path="wardenContactNo" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Hostel Contact No</label><span class="mandatory_star">*</span>
													<form:input type="text" id="hostelContactNo" path="hostelContactNo" class="form-control" />
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createHostel?pid=2&mid=7">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/createHostel?pid=2&mid=7');
rradminportal.common();
rradminportal.hostelMaster();
</script>