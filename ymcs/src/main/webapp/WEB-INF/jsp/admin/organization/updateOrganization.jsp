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
					<div class="panel-heading">Update Organization</div>
					<div class="panel-body">
						<div class="menu_tab">
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="addOrganization">
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
													<form:input type="text" id="organizationCode" path="organizationCode" class="form-control" disabled="disabled"/>
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
													<label>District</label><span class="mandatory_star">*</span>
													<form:input type="text" id="district" path="district" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
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
rradminportal.common();
rradminportal.organization();
</script>