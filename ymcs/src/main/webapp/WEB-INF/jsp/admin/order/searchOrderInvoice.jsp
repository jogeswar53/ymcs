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
					<div class="panel-heading">Search Order</div>
					<div class="panel-body">
						<div class="menu_tab">
							<div class="tab-content pt-20px">
								<div class="tab-pane " id="viewOrder">
								</div>
								<div class="tab-pane active" id="addOrder">
									<form:form id="orderForm" commandName="orderForm">
										<fieldset><legend>Search Information</legend>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Order No</label>
														<form:input type="text" id="orderNo" path="orderNo" class="form-control" />
													</div>
												</div>
											</div>
										</fieldset>
										<div class="row ">
											<div class="col-md-8 text-center pull-right">
												<a class="btn navbar-btn btn-default" 
													href="${contextPath}/admin/viewOrders?pid=12&mid=13">Cancel</a> &nbsp;&nbsp;
												<a class="btn navbar-btn btn-primary" 
													onclick="$(this).closest('form').submit();">Search</a>
											</div>
										</div>
									</form:form>
									<c:if test="${ orderForm.paidAmount gt 0  }">
										<form:form id="updateOrderForm" commandName="orderForm">
											<form:hidden path="orderNo" value="${ orderForm.orderNo }" />
											<form:hidden path="action" value="updateInvoice" />
											<fieldset><legend>Update Information</legend>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label>Advanced Amount</label>
															<form:input type="text" disabled="true" id="paidAmount" path="paidAmount" class="form-control" />
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label>Total Amount</label>
															<form:input type="text" id="totalAmount" path="totalAmount" class="form-control" />
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label>Particulars</label>
															<form:textarea rows="3" type="text" id="particulars" path="particulars" class="form-control" />
														</div>
													</div>
												</div>
											</fieldset>
											<div class="row ">
												<div class="col-md-8 text-center pull-right">
													<a class="btn navbar-btn btn-default" 
														href="${contextPath}/admin/viewOrders?pid=12&mid=13">Cancel</a> &nbsp;&nbsp;
													<a class="btn navbar-btn btn-primary" 
														onclick="$(this).closest('form').submit();">Update</a>
												</div>
											</div>
										</form:form>
									</c:if>
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
</script>