<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form   autocomplete="off"  commandName="emailManagementBean" id="emailManagementBean">
	<section class="insurance_management">
		<div id="breadcrumb">
			<ul>
				<li>Home</li>
				<li>Configuration</li>
				<li>Email Management</li>
				<li>Edit Email Management</li>
			</ul>
		</div>
		<!---breadcrumb--->
		<div class="section_heading">
			<span>Email Template Listing</span>
		</div>
		
<!-- 		<div class="management">-Email Management- -->
			
<!-- 		</div> -->
		<%-- <c:choose>
			<c:when test="${emailManagementBean.contentType eq 1}">
				<div class="section_heading">
					<h5>Email Content Management</h5>
				</div>
			</c:when>
			<c:otherwise>
				<div class="section_heading">
					<h5>Home Page Content Management</h5>
				</div>
			</c:otherwise>
		</c:choose> --%>
		<div class="main_section bg-b-w">
		    <!-------------row----------->
			<div class="row pad_top">
				<%-- <div class="col-md-4">
					<label>Select Content Type</label><span class="mandatory_star">*</span>
					<fieldset class="infield">				
						<form:select id="contentType" path="contentType" class="select_option" disabled="true">
						<form:option value="-1">Select</form:option>
							<c:forEach items="${contentTypes}" var="content">
								<form:option value="${content.key}">${content.value}</form:option>
							</c:forEach>
						</form:select>		
					</fieldset>
				</div> --%>
				<%-- <c:if test="${emailManagementBean.contentType eq 1}"> --%>
					<div class="col-md-3 emailContent">
						<label>Upload Email Template</label><br>
						<input type="text" value="" class="uploadFile" placeholder="Choose file" name="uploadFile" id="uploadFile">
						<div class="fileUpload btn ">
							<span class="bg_w_button">Browse</span> 
							<input type="file" class="upload" style="width:100%;" name="afFileUpload" id="emailUploadBtn">
						</div>
							 <div class="error hide" id="msg"></div>	
					</div>
					<div class="col-md-3  upload upload_rate emailContent uploadFile_button">
						<input class="bg_w_button" type="button" value="Upload File" id="uploadfiles" onclick="uploadContent('uploadFile','emailUploadBtn','mytextarea','content')" />						
					</div>
				<%-- </c:if> --%>
				<!--- status wrap -->
				
				<div class="col-md-4">
					<div class='text top' >
						<label>Status</label><span class="mandatory_star">*</span>
						<div class="half-col last">
							<ul class="list-inline">
								<c:forEach items="${emailStatus}" var="status">
									<li>
										<label>
										<form:radiobutton path="emailStatus" class="css-checkbox" id ="${status.key}" value="${status.key}" />
											<label for="${status.key}" class="css-label radGroup2">${status.value}</label>
										</label>
									</li>
								</c:forEach>
	                        </ul>
	                    </div>
	                </div>
	            </div>
				
			</div>
<%-- 			<c:if test="${emailManagementBean.contentType eq 1}"> --%>
			<div class="row pad_top">
					<div class="col-md-4">
						<label>Title of Email Template</label><span class="mandatory_star">*</span>
						<form:input path="name" id="name" class="form-control"  tabindex="1" />
					</div>
					<div class="col-md-4">
						<label>Subject of Email Template</label><span class="mandatory_star">*</span>
						<form:input path="title" id="title"	class="form-control"  tabindex="1" />
					</div>
				</div> 
<%-- 			</c:if> --%>
			<!-------------row----------->
			<div class="row pad_top text_editor">
				<div class='col-md-12 text_editor'>
						<label>Description</label><span class="mandatory_star">*</span>
						<form:textarea id="mytextarea" path="content" tabindex="4"></form:textarea>
						<span class="display_none" style="color:red;">Please enter question</span>
				</div><!---text editor--->
			</div><!-------------row----------->
		</div>
		<div class="btn_save pull-right">
			<a href="${contextPath}/admin/emailManagement"><input class="bg_g_button" type="button" value="Cancel" /></a>
			<input class="bg_g_button Save_button_error" type="button" value="Update" onClick="$(this).closest('form').submit();"/>
		</div><!----------button----------->
	</section>
</form:form>

<script src='https://cdn.tinymce.com/4/tinymce.min.js'></script>

<script>
$(document).ready(function () {
	
	tinymce.init({
		selector: 'textarea#mytextarea',
		height: '200px',
		plugins: [
	        'advlist autolink lists link image charmap print preview hr anchor pagebreak',
	        'searchreplace wordcount visualblocks visualchars code fullscreen',
	        'insertdatetime media nonbreaking save table contextmenu directionality',
	        'emoticons template paste textcolor colorpicker textpattern imagetools codesample toc'
        ],
        toolbar1: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
        toolbar2: 'print preview media | forecolor backcolor emoticons | codesample',
		setup : function(ed){
			ed.on("NodeChange", function(e){
		    	jQuery("textarea[id='mytextarea']").val(ed.getContent());
		    });
		}
	});
		
	$.validator.addMethod("textareacheck", function(value, element) {
			value=$('#content').val();
			if(value.length==0)
				return false;
			else
				return true;
	});
	$.validator.addMethod('filesize', function (value, element, param) {
	    return this.optional(element) || (element.files[0].size <= param)
	}, 'File size should not be more than 1MB');
	
 	$("#emailManagementBean").validate({
		ignore:[],
		rules: {
				title:{
					required:true,
					rangelength:[1,100]
				},
				name:{
					required:true,
					rangelength:[1,100]
				},
				content:{
					required:true,
				},
				afFileUpload:{
					filesize: 1100000,
					extension: "htm|html",
				}
     },
     messages: {
    	 title:{
        	 required:"Subject of email should not be empty",
        	 rangelength:"Maximum 100 characters permitted"
    	 },
    	 
         name:{
 			required:"Title of email should not be empty",
 			rangelength:"Maximum 100 characters permitted"
 		},
 		content:{
			required:"Please enter some content",
		},
 		afFileUpload : {
 			extension:"Invalid file format. Only htm|html files are allowed."	
 		}
     },
      errorElement: "div",
      errorPlacement: function(error, element) {
   	     if ($(element).hasClass("upload error")) {
   	         error.insertAfter($(element).closest("div"));
   	     } else {
   	         error.insertAfter(element);
   	     }
   	  },
      submitHandler: function (form) {
             form.submit();
     },
     //onfocusout: function(element) { $(element).valid(); }
  });

 	$('#emailUploadBtn').on('change', function(e){
 		$('#uploadFile').val($('#emailUploadBtn').val());
 	});
 	
 	/* $('#uploadBtn').change(function() {
		$('#uploadFile').val(this.value);
		if($('#uploadFile-error').is(":visible") == true){
			$('#uploadFile-error').remove();	
		} 
		var ext = this.value.split('.').pop().toLowerCase();
		 if($.inArray(ext, ['htm','html']) == -1) {
			 $("#msg").show();
			 $('#msg').html("invalid file Format Only htm | html files are allowed.");
			 $('.bg_g_button').off("click"); 
		 } else {
			 $("#msg").hide();
		 }
	});  */
}); 

function uploadContent(valida,id,url,fname){
	var error_css = $("div #emailUploadBtn-error").css('display');
	var formData = new FormData();
	formData.append('file', $("#"+id)[0].files[0]);
	
	if ( (error_css  === undefined) || (error_css  == "none") ) {
		if($("#emailManagementBean").validate().element("#"+valida)){
			$.ajax({
				  url: "${contextPath}/admin/saveUploadContent",
				  data: formData,
				  dataType: 'text',
				  processData: false,
				  contentType: false,
				  type: 'POST',
				  success: function (response) {
					//jQuery("textarea[id='"+url+"']").html(response);
					$(tinymce.get(url).getBody()).html(response); 
					$("#mytextarea").val(response);
					$("#emailManagementBean").validate().element("#mytextarea");
				  }
			});
		}
	}
 }

$(document).on("keydown", function (e) {
    if (e.which === 8 && !$(e.target).is("input, textarea")) {
        e.preventDefault();
    }
});

</script>
