<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>State Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">State Configuration</li>
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
		<div id="viewStateModel" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">State Details</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class='col-md-6'>
								<label>Country Code</label>
								<p id="viewCountryCode" ></p>
							</div>
							<div class='col-md-6'>
								<label>Country Name</label>
								<p id="viewCountryName" ></p>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<label>State Code</label>
								<p id="viewStateCode" ></p>
							</div>
							<div class='col-md-6'>
								<label>State Name</label>
								<p id="viewStateName" ></p>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<label>Status</label>
								<p id="viewStateStatus" ></p>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<button class="bg_g_button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="deleteStateModel" class="modal fade" role="dialog">	
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
						<span> Country will be deleted. Are you sure?</span> 
						<input type="hidden" id="delStateId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteStateId" class="bg_g_button" data-dismiss="modal">Delete</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
	<!-- Model contents ends here  -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Create State</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewState" data-toggle="tab">View State</a></li>
								<li ><a href="#addState" data-toggle="tab">Add State</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewState">
									<div class="box-body responsive-table">
										<c:if test="${ not empty stateList }">
											<table id="state_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Country Name</th>
														<th>State Code</th>
														<th>State Name</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${stateList}" var="state" varStatus="i">
														<tr data-countryname="${ state.countryName }"
															data-id="${ i.count }"
															data-statecode="${ state.stateCode }"
															data-statename="${ state.stateName }">
															<td>${ i.count }</td>
															<td>${ state.countryName }</td>
															<td>${ state.stateCode }</td>
															<td>${ state.stateName }</td>
															<td class="${ state.activeStatusClass }">${ state.activeStatusValue }</td>
															<td>
																<span class="viewState" data-target="#viewStateModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editState">
																	<a href="${contextPath}/admin/updateState?stateId=${ state.stateId }&pid=2&mid=5"><i class="fa fa-edit"></i></a>
																</span>
																<span class="deleteState" data-target="#deleteStateModel">
																	<i class="fa fa-trash"></i>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${ empty stateList }">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane" id="addState">
									<form:form id="addStateForm" commandName="addStateForm">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Country Name</label><span class="mandatory_star">*</span>
													<form:select path="countryCode" class="form-control select2">
														<form:option value="">Select Country</form:option>
														<form:options items="${countryMap}" />
													</form:select>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>State Code</label><span class="mandatory_star">*</span>
													<form:input type="text" id="stateCode" path="stateCode" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>State Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="stateName" path="stateName" class="form-control" />
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createState?pid=2&mid=5">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/createState?pid=2&mid=5');
rradminportal.common();
rradminportal.state();
</script>