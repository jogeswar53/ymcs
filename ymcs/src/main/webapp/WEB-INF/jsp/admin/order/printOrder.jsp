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
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Print Order</div>
					<div class="panel-body">
						<div class="menu_tab">
							<div class="tab-content pt-20px">
								<div class="tab-pane " id="viewOrder">
								</div>
								<div class="tab-pane active" id="addOrder">
									<form:form id="addOrderForm" commandName="addOrderForm">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>First Name</label>
													<p >${ addOrderForm.firstName }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Last Name</label>
													<p >${ addOrderForm.lastName }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Mobile No</label>
													<p >${ addOrderForm.mobileNo }</p>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Email Id</label>
													<p >${ addOrderForm.emailId }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Address</label>
													<p >${ addOrderForm.address }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Brand</label>
													<p >${ addOrderForm.brandName }</p>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Model</label>
													<p >${ addOrderForm.model }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Assigned To</label>
													<p >${ addOrderForm.userName }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Issue Description</label>
													<p >${ addOrderForm.issueDescription }</p>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Select An Issue</label>
													<p >${ addOrderForm.issueName }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Due Date</label>
													<p >${ addOrderForm.dueTime }</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Accessories</label>
													<p >${ addOrderForm.accessories }</p>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Advanced Amount</label>
													<p >${ addOrderForm.paidAmount }</p>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-8 text-center pull-right">
												<a class="btn navbar-btn btn-default" 
													href="${contextPath}/admin/viewOrders?pid=12&mid=13">Cancel</a> &nbsp;&nbsp;
												<a class="btn navbar-btn btn-primary" 
													href="${contextPath}/admin/updateOrder?orderId=
																${ addOrderForm.orderId }&pid=12&mid=13">Edit</a> &nbsp;&nbsp;
												<a class="btn navbar-btn btn-default" onclick="printDiv();">Print</a>
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
function printDiv() {
	$("#addOrder").printThis();
}
</script>