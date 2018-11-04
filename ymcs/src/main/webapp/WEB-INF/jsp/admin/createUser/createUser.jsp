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
														<th>Sr.No.</th>
														<th>User Role</th>
														<th>User Id</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ userProfileList }" var="userProfile" varStatus="i">
														<tr data-id="${ i.count }"
															data-userprofileid="${ userProfile.userProfileId }" >
															<td>${ i.count }</td>
															<td>${ userProfile.roleName }</td>
															<td>${ userProfile.userId }</td>
															<td class="${ userProfile.activeStatusClass }">${ userProfile.activeStatusValue }</td>
															<td>
																<span class="viewUserProfile" data-target="#viewUserProfileModel">
																	<i class="fa fa-eye"></i>
																</span>
																<span class="editUserProfile" data-target="#editUserProfileModel">
																	<i class="fa fa-edit"></i>
																</span>
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
										
<%-- 										<form:input type="text" path="userEducationList[0].className"/> --%>
										<fieldset><legend>Personal Information</legend>
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
														<label>Organization Name</label><span class="mandatory_star">*</span>
															<form:select path="organizationId" class="form-control select2">
																<form:option value="">Select Organization</form:option>
																<form:options items="${organizationMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Country Name</label><span class="mandatory_star">*</span>
															<form:select path="countryId" class="form-control select2">
																<form:option value="">Select Country</form:option>
																<form:options items="${countryMap}" />
															</form:select>
													</div>
												</div>
											</div>
											<div class="row">
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
														<label>Hostel Name</label><span class="mandatory_star">*</span>
															<form:select path="hostelId" class="form-control select2">
																<form:option value="">Select Hostel</form:option>
																<form:options items="${hostelMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Status</label>
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
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>User Title</label><span class="mandatory_star">*</span>
														<form:input type="text" id="userTitle" path="userTitle" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>First Name</label><span class="mandatory_star">*</span>
														<form:input type="text" id="firstName" path="firstName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Middle Name</label>
														<form:input type="text" id="middleName" path="middleName" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Last Name</label><span class="mandatory_star">*</span>
														<form:input type="text" id="lastName" path="lastName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>User Id</label><span class="mandatory_star">*</span>
														<form:input type="text" id="userId" path="userId" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Password</label><span class="mandatory_star">*</span>
														<form:input type="password" id="upassword" path="upassword" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Gender</label><span class="mandatory_star">*</span>
															<form:select path="gender" class="form-control select2">
																<form:option value="">Select Gender</form:option>
																<form:options items="${genderMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Email Id</label><span class="mandatory_star">*</span>
														<form:input type="text" id="emailId" path="emailId" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Mobile No</label><span class="mandatory_star">*</span>
														<form:input type="text" id="mobileNumber" path="mobileNumber" class="form-control" />
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
														<label>Guardian Name</label><span class="mandatory_star">*</span>
														<form:input type="text" id="guardianName" path="guardianName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Mother Name</label><span class="mandatory_star">*</span>
														<form:input type="text" id="motherName" path="motherName" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Permanent Address1</label><span class="mandatory_star">*</span>
														<form:input type="text" id="permanentAddr1" path="permanentAddr1" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Permanent Address2</label><span class="mandatory_star">*</span>
														<form:input type="text" id="permanentAddr2" path="permanentAddr2" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Permanent Address3</label><span class="mandatory_star">*</span>
														<form:input type="text" id="permanentAddr3" path="permanentAddr3" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Present Address1</label><span class="mandatory_star">*</span>
														<form:input type="text" id="presentAddr1" path="presentAddr1" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Present Address2</label><span class="mandatory_star">*</span>
														<form:input type="text" id="presentAddr2" path="presentAddr2" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Present Address3</label><span class="mandatory_star">*</span>
														<form:input type="text" id="presentAddr3" path="presentAddr3" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Nationality</label><span class="mandatory_star">*</span>
															<form:select path="nationality" class="form-control select2">
																<form:option value="0">Select Nationality</form:option>
																<form:options items="${nationalityMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Religion</label><span class="mandatory_star">*</span>
															<form:select path="religion" class="form-control select2">
																<form:option value="0">Select Religion</form:option>
																<form:options items="${religionMap}" />
															</form:select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Is Class Teacher</label><span class="mandatory_star">*</span>
															<form:select path="isClassTeacherYes" class="form-control select2">
																<form:options items="${isClassTeacherYesMap}" />
															</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Select Class</label><span class="mandatory_star">*</span>
														<form:select path="classTeacherClassId" class="form-control select2">
															<form:option value="">Select Class</form:option>
															<form:options items="${classMap}" />
														</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Select Syllabus</label><span class="mandatory_star">*</span>
															<form:select path="syllabusList" id="syllabusListId" class="form-control select2">
<%-- 																<form:options items="${syllabusMap}" /> --%>
															</form:select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<div class="file-box">
															<label>Profile Photo</label>
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
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Voter Id No</label><span class="mandatory_star">*</span>
														<form:input type="text" id="voterIdNo" path="voterIdNo" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<div class="file-box">
															<label>Upload Voter Id</label>
															<input type="file" id="voterIdImg" class="inputfile inputfile-6" />
															<label for="voterIdImg">
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
													<img class="thumb-img" id="img" height="200" width="250" src="${contextPath}/static/img/no_image.jpeg">
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Adhar Card No</label><span class="mandatory_star">*</span>
														<form:input type="text" id="adharCardNo" path="adharCardNo" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<div class="file-box">
															<label>Upload Adhar Card</label>
															<input type="file" id="adharCardImg" path="adharCardImg" class="inputfile inputfile-6" />
															<label for="adharCardImg">
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
													<img class="thumb-img" id="img" height="200" width="250" src="${contextPath}/static/img/no_image.jpeg">
												</div>
											</div>
										</fieldset>
										<fieldset id="educationalInfoFieldSet" class="hide"><legend>Educational Information</legend>
											<fieldset id="classxboardFieldSet"><legend>Class X Board</legend>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Class Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].className' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Grade Or Percentage</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].gradeOrPercentage' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Institute Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].instituteName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Mark Sheet</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].markSheetImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Certificate</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].certificateImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Is Regular</label><span class='mandatory_star'>*</span>
																<form:select path='userEducationList[0].isRegularYes' class='form-control select2'>
																	<form:options items='${isRegularYesMap}' />
																</form:select>
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Year Of Passout</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].yearOfPassOut' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Stream Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].streamName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Honours Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].honoursName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Board or University Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].universityOrBoardName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course Start Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].courseStartDate' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course End Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[0].courseEndDate' class='form-control' />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<i class="fa red fa-minus-circle"></i>
																<a class="delete-new-form-element" onclick="deleteFieldSet('educationalInfoFieldSet')">Delete Class X Board</a>
														</div>
													</div>
												</div>
											</fieldset>
											<fieldset id="classxiiboardFieldSet" class="hide"><legend>Class XII Board</legend>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Class Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].className' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Grade Or Percentage</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].gradeOrPercentage' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Institute Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].instituteName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Mark Sheet</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].markSheetImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Certificate</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].certificateImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Is Regular</label><span class='mandatory_star'>*</span>
																<form:select path='userEducationList[1].isRegularYes' class='form-control select2'>
																	<form:options items='${isRegularYesMap}' />
																</form:select>
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Year Of Passout</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].yearOfPassOut' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Stream Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].streamName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Honours Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].honoursName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Board or University Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].universityOrBoardName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course Start Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].courseStartDate' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course End Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[1].courseEndDate' class='form-control' />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<i class="fa red fa-minus-circle"></i>
																<a class="delete-new-form-element" onclick="deleteFieldSet('classxiiboardFieldSet')">Delete Class XII Board</a>
														</div>
													</div>
												</div>
											</fieldset>
											<fieldset id="graduationFieldSet" class="hide"><legend>Basic/Graduation</legend>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Class Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].className' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Grade Or Percentage</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].gradeOrPercentage' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Institute Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].instituteName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Mark Sheet</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].markSheetImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Certificate</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].certificateImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Is Regular</label><span class='mandatory_star'>*</span>
																<form:select path='userEducationList[2].isRegularYes' class='form-control select2'>
																	<form:options items='${isRegularYesMap}' />
																</form:select>
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Year Of Passout</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].yearOfPassOut' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Stream Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].streamName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Honours Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].honoursName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Board or University Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].universityOrBoardName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course Start Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].courseStartDate' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course End Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[2].courseEndDate' class='form-control' />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<i class="fa red fa-minus-circle"></i>
																<a class="delete-new-form-element" onclick="deleteFieldSet('graduationFieldSet')">Delete Basic/Graduation</a>
														</div>
													</div>
												</div>
											</fieldset>
											<fieldset id="postGraduationFieldSet" class="hide"><legend>Post Graduation</legend>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Class Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].className' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Grade Or Percentage</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].gradeOrPercentage' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Institute Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].instituteName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Mark Sheet</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].markSheetImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Certificate</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].certificateImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Is Regular</label><span class='mandatory_star'>*</span>
																<form:select path='userEducationList[3].isRegularYes' class='form-control select2'>
																	<form:options items='${isRegularYesMap}' />
																</form:select>
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Year Of Passout</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].yearOfPassOut' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Stream Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].streamName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Honours Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].honoursName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Board or University Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].universityOrBoardName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course Start Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].courseStartDate' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course End Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[3].courseEndDate' class='form-control' />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<i class="fa red fa-minus-circle"></i>
																<a class="delete-new-form-element" onclick="deleteFieldSet('postGraduationFieldSet')">Delete Post Graduation</a>
														</div>
													</div>
												</div>
											</fieldset>
											<fieldset id="doctoratePhdFieldSet" class="hide"><legend>Doctorate/PhD</legend>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Class Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].className' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Grade Or Percentage</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].gradeOrPercentage' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Institute Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].instituteName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Mark Sheet</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].markSheetImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Upload Certificate</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].certificateImg' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Is Regular</label><span class='mandatory_star'>*</span>
																<form:select path='userEducationList[4].isRegularYes' class='form-control select2'>
																	<form:options items='${isRegularYesMap}' />
																</form:select>
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Year Of Passout</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].yearOfPassOut' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Stream Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].streamName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Honours Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].honoursName' class='form-control' />
														</div>
													</div>
												</div>
												<div class='row'>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Board or University Name</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].universityOrBoardName' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course Start Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].courseStartDate' class='form-control' />
														</div>
													</div>
													<div class='col-md-4'>
														<div class='form-group'>
															<label>Course End Date</label><span class='mandatory_star'>*</span>
															<form:input type='text' path='userEducationList[4].courseEndDate' class='form-control' />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<i class="fa red fa-minus-circle"></i>
																<a class="delete-new-form-element" onclick="deleteFieldSet('doctoratePhdFieldSet')">Delete Doctorate/PhD</a>
														</div>
													</div>
												</div>
											</fieldset>
										</fieldset>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<i class="fa fa-plus"></i><a class="add-new-form-element" id="addEducation">Add Education</a>
												</div>
											</div>
										</div>
										<fieldset id="employmentInfoFieldSet" class="hide"><legend>Employment Information</legend>
											<div id="employmentInfo"></div>
										</fieldset>
										<fieldset id="studentInfoFieldSet" class="hide"><legend>Student Information</legend>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Select Class</label><span class="mandatory_star">*</span>
														<form:select path="classId" class="form-control select2">
															<form:option value="">Select Class</form:option>
															<form:options items="${classMap}" />
														</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Select Section</label><span class="mandatory_star">*</span>
														<form:select path="sectionId" class="form-control select2">
															<form:option value="">Select Section</form:option>
															<form:options items="${sectionMap}" />
														</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Is Transport</label><span class="mandatory_star">*</span>
														<form:select path="isTransportYes" class="form-control select2">
															<form:options items="${isTransportYesMap}" />
														</form:select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Bus Route No</label><span class="mandatory_star">*</span>
														<form:input type="text" id="busRouteNo" path="busRouteNo" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Is Transfer</label><span class="mandatory_star">*</span>
														<form:select path="isTransferYes" class="form-control select2">
															<form:options items="${isTransferYesMap}" />
														</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Upload CLS/SLS</label><span class="mandatory_star">*</span>
														<form:input type="text" id="leavingCertificateImg" path="leavingCertificateImg" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Old Organization Leaving Date</label><span class="mandatory_star">*</span>
														<form:input type="text" id="oldOrgLeavingDate" path="oldOrgLeavingDate" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Old Organization Name</label><span class="mandatory_star">*</span>
														<form:input type="text" id="oldOrgName" path="oldOrgName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Old Organization Contact No</label><span class="mandatory_star">*</span>
														<form:input type="text" id="oldOrgContactNo" path="oldOrgContactNo" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Is Uniform</label><span class="mandatory_star">*</span>
														<form:select path="isUniformYes" class="form-control select2">
															<form:options items="${isUniformYesMap}" />
														</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Total Fees</label><span class="mandatory_star">*</span>
														<form:input type="text" id="fees" path="fees" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Paid Fees</label><span class="mandatory_star">*</span>
														<form:input type="text" id="paidFees" path="paidFees" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<i class="fa red fa-minus-circle"></i>
															<a class="delete-new-form-element" onclick="deleteFieldSet('studentInfoFieldSet')">Delete Student Info</a>
													</div>
												</div>
											</div>
										</fieldset>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<i class="fa fa-plus"></i><a class="add-new-form-element" id="addStudentInfo">Add Student Info</a>
												</div>
											</div>
										</div>
										<div id="testIds"></div>
										<fieldset id="studentInfoFieldSet" class="clonedInput hide"><legend>Employment Information</legend>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Designation</label><span class="mandatory_star">*</span>
														<form:input type="text" id="designation" path="userEmploymentList[0].designation" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Organization Name</label><span class="mandatory_star">*</span>
														<form:input type="text" id="organizationName" path="userEmploymentList[0].organizationName" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Upload Experience certificate</label><span class="mandatory_star">*</span>
														<form:input type="text" id="experienceCertificateImg" path="userEmploymentList[0].experienceCertificateImg" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Date Of Joining</label><span class="mandatory_star">*</span>
														<form:input type="text" id="orgDateOfJoining" path="userEmploymentList[0].orgDateOfJoining" class="form-control" />
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>Date Of Leaving</label><span class="mandatory_star">*</span>
														<form:input type="text" id="dateOfLeaving" path="userEmploymentList[0].dateOfLeaving" class="form-control" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<i class="fa red fa-minus-circle"></i>
															<a class="delete-new-form-element" onclick="deleteFieldSet('studentInfoFieldSet')">Delete Employment Info</a>
													</div>
												</div>
											</div>
										</fieldset>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<i class="fa fa-plus"></i><a class="add-new-form-element" id="addEmployment">Add Employment</a>
												</div>
											</div>
										</div>
										<div class="row ">
											<div class="col-md-8 text-right pull-right">
												<a class="btn navbar-btn btn-default" href="${contextPath}/admin/createUser?pid=2&mid=10">Cancel</a> &nbsp;&nbsp;
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
changeURL('admin/createUser?pid=2&mid=10');
rradminportal.common();
rradminportal.createUser();

setTimeout(function () {
	$("#userId").val("");
	$("#upassword").val("");
}, 600);

var educationalFields = 0;
$("#addStudentInfo").click(function(){
	$("#studentInfoFieldSet").removeClass("hide");
});
$("#addEducation").click(function(){
	if (!$("#postGraduationFieldSet").hasClass("hide")) {
		$("#doctoratePhdFieldSet").removeClass("hide");
	}
	if (!$("#graduationFieldSet").hasClass("hide")) {
		$("#postGraduationFieldSet").removeClass("hide");
	}
	if (!$("#classxiiboardFieldSet").hasClass("hide")) {
		$("#graduationFieldSet").removeClass("hide");
	}
	if (!$("#educationalInfoFieldSet").hasClass("hide")) {
		$("#classxiiboardFieldSet").removeClass("hide");
	}
	$("#educationalInfoFieldSet").removeClass("hide");
});
function deleteFieldSet(hideElement) {
	$("#"+hideElement).addClass("hide");
}
var regex = /^(.+?)(\d+)$/i;
var cloneIndex = $(".clonedInput").length;

$("#addEmployment").click(function(){
	$(".clonedInput").removeClass("hide");
	$(".clonedInput").clone()
	.appendTo(document.getElementById("testIds"))
	.attr("id", "clonedInput" + cloneIndex)
	.find("*")
	.each(function() {
		var name = this.name;
		if(undefined != name) {
			this.name = "userEmploymentList["+cloneIndex+"].designation";
		}
		var id = this.id || "";
		var match = id.match(regex) || [];
		if (match.length == 3) {
			this.id = match[1] + (cloneIndex);
		}
	})
	.on('click', 'button.remove', remove);
	cloneIndex++;
});
function remove(removeElement){
	//$("."+removeElement).remove();
	$(this).remove();
}
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