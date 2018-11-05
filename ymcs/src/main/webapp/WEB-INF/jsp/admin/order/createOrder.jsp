<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>Order</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Order</li>
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
		<div id="deleteOrderModel" class="modal fade" role="dialog">
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
						<span> Order will be deleted. Are you sure?</span> 
						<input type="hidden" id="delOrderId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteOrderId" class="bg_g_button" data-dismiss="modal">Delete</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
	<!-- Model contents ends here  -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Create Order</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li ><a href="#viewOrder" data-toggle="tab">View Orders</a></li>
								<li class="active"><a href="#addOrder" data-toggle="tab">Create Order</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane " id="viewOrder">
									<div class="box-body responsive-table">
										<c:if test="${ not empty OrderList }">
											<table id="Order_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Order Code</th>
														<th>Order Name</th>
														<th>Order Address</th>
														<th>Warden Name</th>
														<th>Warden Contact No</th>
														<th>Order Contact No</th>
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
																<span class="viewOrder" data-target="#viewOrderModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editOrder" data-target="#editOrderModel">
																	<i class="fa fa-edit"></i>
																</span>
																<span class="deleteOrder" data-target="#deleteOrderModel">
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
								<div class="tab-pane active" id="addOrder">
									<form:form id="addOrderForm" commandName="addOrderForm">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>First Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="firstName" path="firstName" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Last Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="lastName" path="lastName" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Mobile No</label><span class="mandatory_star">*</span>
													<form:input type="text" id="mobileNo" path="mobileNo" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Email Id</label>
													<form:input type="text" id="emailId" path="emailId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Address</label><span class="mandatory_star">*</span>
													<form:input type="text" id="address" path="address" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Brand</label><span class="mandatory_star">*</span>
														<form:select path="brand" class="form-control select2">
															<form:option value="">Select Brand</form:option>
															<form:options items="${brandMap}" />
														</form:select>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Model</label>
													<form:input type="text" id="emailId" path="emailId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Assigned To</label><span class="mandatory_star">*</span>
													<form:input type="text" id="address" path="address" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Issue Description</label><span class="mandatory_star">*</span>
													<form:input type="text" id="brand" path="brand" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Select An Issue</label>
													<form:input type="text" id="emailId" path="emailId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Due Date</label><span class="mandatory_star">*</span>
													<form:input type="text" id="address" path="address" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Accessories</label><span class="mandatory_star">*</span>
													<form:input type="text" id="brand" path="brand" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Advanced Amount</label>
													<form:input type="text" id="emailId" path="emailId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
<!-- 													<label>Due Date</label><span class="mandatory_star">*</span> -->
<%-- 													<form:input type="text" id="address" path="address" class="form-control" /> --%>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
<!-- 													<label>Accessories</label><span class="mandatory_star">*</span> -->
<%-- 													<form:input type="text" id="brand" path="brand" class="form-control" /> --%>
												</div>
											</div>
										</div>
										<div class="row ">
											<div class="col-md-8 text-center pull-right">
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/order?pid=0&mid=8">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/order?pid=0&mid=8');
rradminportal.common();
rradminportal.hostelMaster();
</script>