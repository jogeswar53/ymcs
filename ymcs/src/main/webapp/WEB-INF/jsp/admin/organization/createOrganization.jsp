<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>Organization Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Organization Configuration</li>
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
					<div class="panel-heading">Create Organization</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewOrganization" data-toggle="tab">View Organization</a></li>
								<li ><a href="#addOrganization" data-toggle="tab">Add Organization</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewOrganization">
									<div class="box-body org-table responsive-table">
										<c:if test="${not empty organizationList}">
											<table id="organization_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Country Name</th>
														<th>State Name</th>
														<th>Organization code</th>
														<th>Organization Name</th>
														<th>Organization Addr1</th>
														<th>Organization Addr2</th>
														<th>Organization Addr3</th>
														<th>Pincode</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${organizationList}" var="organization" varStatus="i">
														<tr data-id="${i.count}"
															data-countryid="${organization.organizationId}"
															data-countryname="${organization.countryName}"
															data-currencycode="${organization.stateName}"
															data-currencyname="${organization.organizationCode}"
															data-activestatus="${organization.status}"
															data-isdcode="${organization.organizationName}"
															data-isdcode="${organization.organizationAddr1}"
															data-isdcode="${organization.organizationAddr2}"
															data-isdcode="${organization.organizationAddr3}"
															data-isdcode="${organization.pincode}" >
															<td>${i.count}</td>
															<td>${organization.countryName}</td>
															<td>${organization.stateName}</td>
															<td><a href="${contextPath}/admin/updateOrganization?organizationId=${ organization.organizationId }&pid=0&mid=5">${organization.organizationCode}</a></td>
															<td>${organization.organizationName}</td>
															<td>${organization.organizationAddr1}</td>
															<td>${organization.organizationAddr2}</td>
															<td>${organization.organizationAddr3}</td>
															<td>${organization.pincode}</td>
															<td class="${ organization.statusClass }">${organization.status}</td>
															<td>
																<span class="deleteOrganization" data-target="#deleteOrganizationModel">
																	<i class="fa fa-trash"></i>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${empty organizationList}">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane" id="addOrganization">
									<form:form id="addOrganizationForm" commandName="addOrganizationForm">
										<div class="row">
											<div class="col-md-3">
												<div class="form-group">
													<label>Country Name</label><span class="mandatory_star">*</span>
													<fieldset class="infield">
														<form:select path="countryCode" class="form-control select2">
															<form:option value="">Select Country</form:option>
															<form:options items="${countryMap}" />
														</form:select>
													</fieldset>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>State Name</label><span class="mandatory_star">*</span>
													<fieldset class="infield">
														<form:select path="stateCode" class="form-control select2">
															<form:option value="">Select State</form:option>
															<form:options items="${stateMap}" />
														</form:select>
													</fieldset>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Organization Code</label><span class="mandatory_star">*</span>
													<form:input type="text" id="organizationCode" path="organizationCode" class="form-control" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Organization Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="organizationName" path="organizationName" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-3">
												<div class="form-group">
													<label>Address 1</label><span class="mandatory_star">*</span>
													<form:input type="text" id="organizationAddr1" path="organizationAddr1" class="form-control" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Address 2</label><span class="mandatory_star">*</span>
													<form:input type="text" id="organizationAddr2" path="organizationAddr2" class="form-control" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Address 3</label><span class="mandatory_star">*</span>
													<form:input type="text" id="organizationAddr3" path="organizationAddr3" class="form-control" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Telephone No</label><span class="mandatory_star">*</span>
													<form:input type="text" id="telephoneNo" path="telephoneNo" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-3">
												<div class="form-group">
													<label>Mobile No</label><span class="mandatory_star">*</span>
													<form:input type="text" id="mobileNo" path="mobileNo" class="form-control" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Pincode</label><span class="mandatory_star">*</span>
													<form:input type="text" id="pincode" path="pincode" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Status</label><span class="mandatory_star">*</span>
													<ul class="list-inline">
														<c:forEach items="${activeStatus}" var="status">
															<li>
																<label>
																	<form:radiobutton path="status" class="css-checkbox" id="${status.key}" value="${status.key}" />
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createOrganization?pid=0&mid=5">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/createOrganization?pid=0&mid=5');
rradminportal.common();
rradminportal.organization();
</script>