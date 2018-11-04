<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>Notification Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Notification Configuration</li>
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
		<div id="viewNotificationModel" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Notification Details</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class='col-md-6'>
								<label>Notification Code</label>
								<p id="viewNotificationCode" ></p>
							</div>
							<div class='col-md-6'>
								<label>Notification Name</label>
								<p id="viewNotificationName" ></p>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<label>Status</label>
								<p id="viewNotificationStatus" ></p>
							</div>
						</div>
					</div>
					<div class="modal-footer align-center">
						<button class="bg_g_button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="deleteNotificationModel" class="modal fade" role="dialog">
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
						<span> Notification will be deleted. Are you sure?</span> 
						<input type="hidden" id="delNotificationId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteNotificationId" class="bg_g_button" data-dismiss="modal">Delete</button>
				</div>
			</div><!---modal content--->
			</div>
		</div>
	<!-- Model contents ends here  -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Create Notification</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewNotification" data-toggle="tab">View Notifications</a></li>
								<li ><a href="#addNotification" data-toggle="tab">Add Notification</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewNotification">
									<div class="box-body responsive-table">
										<c:if test="${ not empty notificationList }">
											<table id="notification_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Sr.No.</th>
														<th>Notification Name</th>
														<th>Notification Description</th>
														<th>Notification Scheduled Time</th>
														<th>Created Time</th>
														<th>Created By</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ notificationList }" var="notifications" varStatus="i">
														<tr data-id="${ i.count }"
															data-Notificationid="${ notifications.notificationId }"
															data-Notificationname="${ notifications.notificationName }" >
															<td>${ i.count }</td>
															<td>${ notifications.notificationName }</td>
															<td>${ notifications.notificationDesc }</td>
															<td>${ notifications.scheduledTime }</td>
															<td>${ notifications.createdTime }</td>
															<td>${ notifications.createdBy }</td>
															<td class="${ notifications.activeStatusClass }">${ notifications.activeStatusValue }</td>
															<td>
																<span class="viewNotification" data-target="#viewNotificationModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editNotification" data-target="#editNotificationModel">
																<a href="${contextPath}/admin/updateNotification?notificationId=${ notifications.notificationId }&pid=2&mid=14"><i class="fa fa-edit"></i></a>
																</span>
																<span class="deleteNotification" data-target="#deleteNotificationModel">
																<a href="${contextPath}/admin/deleteNotification?notificationId=${ notifications.notificationId }&pid=2&mid=14"><i class="fa fa-trash"></i></a>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${ empty notificationList }">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane" id="addNotification">
									<form:form id="addNotificationForm" commandName="addNotificationForm">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Notification Name</label><span class="mandatory_star">*</span>
													<form:input type="text" id="notificationName" path="notificationName" class="form-control" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Notification Description</label><span class="mandatory_star">*</span>
													<form:input type="text" id="notificationDesc" path="notificationDesc" class="form-control" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Scheduled Time</label><span class="mandatory_star">*</span>
													<div class="input-group date">
															<div class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</div>
															<form:input type="text" id="scheduledTime" path="scheduledTime" class="pick-date form-control pull-right" readonly="true" />
														</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Status</label><span class="mandatory_star">*</span>
													<%-- <form:input type="text" id="notificationStatus" path="notificationStatus" class="form-control" /> --%>
													<ul class="list-inline">
															<c:forEach items="${notificationStatus}" var="status">
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
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createNotification?pid=2&mid=14">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/createNotification?pid=2&mid=14');
rradminportal.common();
rradminportal.notification();
</script>