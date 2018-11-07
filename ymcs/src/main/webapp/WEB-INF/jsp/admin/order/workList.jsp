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
					<div class="panel-heading">View Orders</div>
					<div class="panel-body">
						<div class="menu_tab">
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewOrder">
									<div class="box-body responsive-table">
										<c:if test="${ not empty orders }">
											<table id="Order_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Srl.No.</th>
														<th>Order No</th>
														<th>Assigned To</th>
														<th>First Name</th>
														<th>Address</th>
														<th>Mobile No</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ orders }" var="order" varStatus="i">
														<tr data-id="${ i.count }" >
															<td>
																<a href="${contextPath}/admin/viewOrder?orderId=
																${ order.orderId }&pid=0&mid=14">${ order.orderId }</a>
															</td>
															<td>${ order.orderNo }</td>
															<td>${ order.userName }</td>
															<td>${ order.firstName }</td>
															<td>${ order.address }</td>
															<td>${ order.mobileNo }</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${ empty orders }">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
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
changeURL('admin/workList?pid=0&mid=14');
rradminportal.common();
rradminportal.order();
</script>