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
							<div class="tab-content pt-20px">
								<div class="tab-pane " id="viewOrder">
								</div>
								<div class="tab-pane active" id="addOrder">
									<form:form id="addOrderForm" commandName="addOrderForm" action="order">
										<form:hidden path="action" value="update" />
										<form:hidden path="orderId" value="${ addOrderForm.orderId }" />
										<form:hidden path="orderNo" value="${ addOrderForm.orderNo }" />
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>First Name</label><span class="mandatory_star">*</span>
													<form:input type="text" maxlength="100" id="firstName" path="firstName" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Last Name</label>
													<form:input type="text" maxlength="50" id="lastName" path="lastName" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Mobile No</label><span class="mandatory_star">*</span>
													<form:input type="text" maxlength="10" id="mobileNo" path="mobileNo" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Email Id</label>
													<form:input type="text" maxlength="200" id="emailId" path="emailId" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Address</label>
													<form:textarea rows="3" type="text" maxlength="200" id="address" path="address" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Brand</label><span class="mandatory_star">*</span>
													<form:select path="brandId" class="form-control select2">
														<form:option value="">Select Brand</form:option>
														<form:options items="${brandMap}" />
													</form:select>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Model</label><span class="mandatory_star">*</span>
													<form:input type="text" maxlength="200" id="model" path="model" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Assigned To</label><span class="mandatory_star">*</span>
													<form:select path="userProfileId" class="form-control select2">
														<form:option value="">Select User</form:option>
														<form:options items="${userMap}" />
													</form:select>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Issue Description</label>
													<form:textarea type="text" id="issueDescription" rows="3" path="issueDescription" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Select An Issue</label><span class="mandatory_star">*</span>
														<form:select path="issueId" class="form-control select2">
															<form:option value="">Select Issue</form:option>
															<form:options items="${issueMap}" />
														</form:select>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Due Date</label>
													<div class="input-group date">
														<div class="input-group-addon">
															<i class="fa fa-calendar"></i>
														</div>
														<form:input type="text" id="dueTime" path="dueTime" class="pick-date form-control pull-right" readonly="true" />
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Accessories</label>
													<form:textarea type="text" id="accessories" path="accessories" rows="3" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Advanced Amount</label>
													<form:input type="text" id="paidAmount" path="paidAmount" class="form-control" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Payment Status</label>
													<form:select path="paymentStatus" class="form-control select2">
														<form:option value="">Select Status</form:option>
														<form:options items="${paymentStatusMap}" />
													</form:select>
												</div>
											</div>
										</div>
										<div class="row ">
											<div class="col-md-8 text-center pull-right">
												<a class="btn navbar-btn btn-default" 
													href="${contextPath}/admin/viewOrders?pid=12&mid=13">Cancel</a> &nbsp;&nbsp;
												<a class="btn navbar-btn btn-primary" 
													onclick="$(this).closest('form').submit();">Save</a>
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
rradminportal.order();
</script>