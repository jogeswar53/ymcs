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
	
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Update Notification</div>
					<div class="panel-body">
						<div class="menu_tab">
							
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="addNotification">
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
rradminportal.common();
rradminportal.notification();
</script>