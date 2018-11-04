<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>Country Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Country Configuration</li>
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
		<div id="viewCountryModel" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Country Details</h4>
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
								<label>Currency Code</label>
								<p id="viewCurrencyCode" ></p>
							</div>
							<div class='col-md-6'>
								<label>Currency Name</label>
								<p id="viewCurrencyName" ></p>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<label>ISD Code</label>
								<p id="viewIsdCode" ></p>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<button class="bg_g_button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="editCountryModel" class="modal fade" role="dialog">
			<form:form id="editCountryForm" commandName="addCountryForm">
				<form:input type="hidden" path="action" value="updateCountry" />
				<form:input type="hidden" path="countryId" id="editCountryId" />
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Country Details</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class='col-md-6'>
									<label>Country Code</label>
									<form:input type="text" id="editCountryCode" path="countryCode" class="form-control" />
								</div>
								<div class='col-md-6'>
									<label>Country Name</label>
									<form:input type="text" id="editCountryName" path="countryName" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class='col-md-6'>
									<label>Currency Code</label>
									<form:input type="text" id="editCurrencyCode" path="currencyCode" class="form-control" />
								</div>
								<div class='col-md-6'>
									<label>Currency Name</label>
									<form:input type="text" id="editCurrencyName" path="currencyName" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class='col-md-6'>
									<label>ISD Code</label>
									<form:input type="text" id="editIsdCode" path="isdCode" class="form-control" />
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Status</label>
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
							<button class="bg_g_button" data-dismiss="modal">Cancel</button>
							<button class="bg_g_button" onclick="$(this).closest('form').submit();">Update</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
		<div id="deleteCountryModel" class="modal fade" role="dialog">	
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
						<input type="hidden" id="delCountryId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteCountryId" class="bg_g_button" data-dismiss="modal">Delete</button>
					<button class="bg_g_button" data-dismiss="modal">Cancel</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
	<!-- Model contents ends here  -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Create Country</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewCountry" data-toggle="tab">View Countries</a></li>
								<li ><a href="#addCountry" data-toggle="tab">Add Country</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewCountry">
									<div class="box-body responsive-table">
										<c:if test="${not empty countryList}">
											<table id="country_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Country Code</th>
														<th>Country Name</th>
														<th>ISD Code</th>
														<th>Currency Code</th>
														<th>Currency Name</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${countryList}" var="country" varStatus="i">
														<tr data-countrycode="${country.countryCode}"
															data-id="${i.count}"
															data-countryid="${country.countryId}"
															data-countryname="${country.countryName}"
															data-currencycode="${country.currencyCode}"
															data-currencyname="${country.currencyName}"
															data-activestatus="${country.activeStatus}"
															data-isdcode="${country.isdCode}">
															<td>${ i.count }</td>
															<td>${ country.countryCode }</td>
															<td>${ country.countryName }</td>
															<td>${ country.isdCode }</td>
															<td>${ country.currencyCode }</td>
															<td>${ country.currencyName }</td>
															<td class="${ country.activeStatusClass }">${ country.activeStatusValue }</td>
															<td>
																<span class="viewCountry" data-target="#viewCountryModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editCountry" data-target="#editCountryModel">
																	<i class="fa fa-edit"></i>
																</span>
																<span class="deleteCountry" data-target="#deleteCountryModel">
																	<i class="fa fa-trash"></i>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${empty countryList}">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane" id="addCountry">
									<form:form id="addCountryForm" commandName="addCountryForm">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Country Code</label><span class="mandatory_star">*</span>
													<form:input type="text" id="countryCode" path="countryCode" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Country Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="countryName" path="countryName" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Currency Code</label><span class="mandatory_star">*</span>
													<form:input type="text" id="currencyCode" path="currencyCode" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Currency Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="currencyName" path="currencyName" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>ISD Code</label><span class="mandatory_star">*</span>
													<form:input type="text" id="isdCode" path="isdCode" class="form-control" />
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createCountry?pid=2&mid=4">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/createCountry?pid=2&mid=4');
rradminportal.common();
rradminportal.country();
</script>