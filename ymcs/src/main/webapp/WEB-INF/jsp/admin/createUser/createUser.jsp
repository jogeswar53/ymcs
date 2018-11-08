<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Home <small>User Profile Configuration</small></h1>
		<ol class="breadcrumb">
			<li><a href="${contextPath}/admin/dashboard?pid=0&mid=1"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">User Profile Configuration</li>
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
		<div id="deleteUserProfileModel" class="modal fade" role="dialog">
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
						<span> User Profile will be deleted. Are you sure?</span> 
						<input type="hidden" id="delUserProfileId"/>
					</p>
				</div><!---body--->
				<div class="modal-footer align-center">
					<button id="deleteUserProfileId" class="bg_g_button" data-dismiss="modal">Delete</button>
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
					<div class="panel-heading">Create User Profile</div>
					<div class="panel-body">
						<div class="menu_tab">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#viewUserProfile" data-toggle="tab">View User Profiles</a></li>
								<li ><a href="#addUserProfile" data-toggle="tab">Add User Profile</a></li>
							</ul>
							<div class="tab-content pt-20px">
								<div class="tab-pane active" id="viewUserProfile">
									<div class="box-body responsive-table">
										<c:if test="${ not empty userProfileList }">
											<table id="class_table" class="portal-table table table-bordered table-hover" width="98%">
												<thead>
													<tr>
														<th>Id</th>
														<th>User Name</th>
														<th>User Role</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ userProfileList }" var="userProfile" varStatus="i">
														<tr data-id="${ i.count }">
															<td>
																<a href="${contextPath}/admin/viewUser?profileId=
															${ userProfile.userProfileId }&pid=0&mid=6">${ userProfile.userProfileId }</a>
															</td>
															<td>${ userProfile.userName }</td>
															<td>${ userProfile.roleName }</td>
															<td class="${ userProfile.statusClass }">${ userProfile.status }</td>
															<td align="center">
																<span class="deleteUserProfile" data-target="#deleteUserProfileModel">
																	<i class="fa fa-trash"></i>
																</span>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</c:if>
										<c:if test="${ empty userProfileList }">
											<div class="alertMessage red">No Record Found</div>
										</c:if>
									</div>
								</div>
								<div class="tab-pane form-style-3 " id="addUserProfile">
									<form:form id="addUserProfileForm" commandName="addUserProfileForm" enctype="multipart/form-data">
										<form:input type="hidden" id="profilePhotoImgId" path="profilePhotoImg" />
										<form:input type="hidden" id="voterIdImgId" path="voterIdImg" />
										<form:input type="hidden" id="adharCardImgId" path="adharCardImg" />
										
										<fieldset><legend>Personal Information</legend>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Country Name</label><span class="mandatory_star">*</span>
															<form:select path="countryId" class="form-control select2">
																<form:option value="">Select Country</form:option>
																<form:options items="${countryMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>State Name</label><span class="mandatory_star">*</span>
															<form:select path="stateId" class="form-control select2">
																<form:option value="">Select State</form:option>
																<form:options items="${stateMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Organization Name</label><span class="mandatory_star">*</span>
															<form:select path="organizationId" class="form-control select2">
																<form:option value="">Select Organization</form:option>
																<form:options items="${organizationMap}" />
															</form:select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Role Name</label><span class="mandatory_star">*</span>
															<form:select path="userRoleId" class="form-control select2">
																<form:option value="">Select Role</form:option>
																<form:options items="${userRoleMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>User Title</label><span class="mandatory_star">*</span>
															<form:select path="userTitle" class="form-control select2">
																<form:option value="">Select Title</form:option>
																<form:options items="${titleMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>First Name</label><span class="mandatory_star">*</span>
														<form:input type="text" maxlength="30" id="firstName" path="firstName" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Middle Name</label>
														<form:input type="text" maxlength="30" id="middleName" path="middleName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Last Name</label>
														<form:input type="text" maxlength="30" id="lastName" path="lastName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Gender</label><span class="mandatory_star">*</span>
															<form:select path="gender" class="form-control select2">
																<form:option value="">Select Gender</form:option>
																<form:options items="${genderMap}" />
															</form:select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>User Name</label><span class="mandatory_star">*</span>
														<form:input type="text" maxlength="20" id="userName" path="userName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Password</label><span class="mandatory_star">*</span>
														<form:input type="password" id="upassword" maxlength="20" path="upassword" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Status</label>
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
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Date Of Birth</label><span class="mandatory_star">*</span>
														<div class="input-group date">
															<div class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</div>
															<form:input type="text" id="dateOfBirth" path="dateOfBirth" class="pick-date form-control pull-right" readonly="true" />
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Email Id</label><span class="mandatory_star">*</span>
														<form:input type="text" maxlength="250" id="emailId" path="emailId" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Mobile No</label><span class="mandatory_star">*</span>
														<form:input type="text" maxlength="10" id="mobileNumber" path="mobileNumber" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Date Of Joining</label><span class="mandatory_star">*</span>
														<div class="input-group date">
															<div class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</div>
															<form:input type="text" id="dateOfJoining" path="dateOfJoining" class="pick-date form-control pull-right" readonly="true" />
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Voter Id No</label>
														<form:input type="text" maxlength="20" id="voterIdNo" path="voterIdNo" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Adhar Card No</label>
														<form:input type="text" maxlength="20" id="adharCardNo" path="adharCardNo" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<div class="file-box">
															<label>Profile Photo</label><span class="mandatory_star">*</span>
															<input type="file" id="profilePhotoImg" class="inputfile inputfile-6" />
															<label for="profilePhotoImg">
																<span></span>
																<strong>
																	<i class="fa fa-cloud-upload"></i>
																	Choose a file..
																</strong>
															</label>
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<img class="thumb-img" id="img" height="200" width="250" src="${contextPath}/static/img/no_profile_image.png">
												</div>
											</div>
										</fieldset>
										<div class="row ">
											<div class="col-md-8 text-right pull-right">
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createUser?pid=0&mid=6">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/createUser?pid=0&mid=6');
rradminportal.common();
rradminportal.createUser();

setTimeout(function () {
	$("#userName").val("");
	$("#upassword").val("");
}, 600);

$("#profilePhotoImg").on('change', function(){
	if (this.files[0] != undefined) {
		getFile("img", "profilePhotoImgId", this.files[0], "profilePhotoImg");
	} else {
		clearFile("img", "profilePhotoImgId", (ctx + '/static/img/no_profile_image.png'), "profilePhotoImg");
	}
});

function getFile(imageId, byteId, file, spanId) {
	var FR= new FileReader();

	FR.addEventListener("load", function(e) {
		document.getElementById(imageId).src       = e.target.result;
		document.getElementById(byteId).value = e.target.result;
		$("#"+spanId).next().find('span').html(file.name);
	});

	FR.readAsDataURL( file );
}
function clearFile(imageId, byteId, noImage, spanId) {
	document.getElementById(imageId).src       = noImage;
	document.getElementById(byteId).value = '';
	$("#"+spanId).next().find('span').html("");
}

</script>