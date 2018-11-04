<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form   autocomplete="off"  commandName="emailManagementBean" id="emailManagementBean">
<section class="insurance_management">
	<div id="breadcrumb">
		<ul>
			<li>Home</li>
			<li>Configuration</li>
			<li>Email Management</li>
<!-- 			<li>Content/Email Management</li> -->
			<li>Add Email Management</li>
<!-- 			<li>Add Content/Email Management</li> -->
		</ul>
	</div>
	<!---breadcrumb--->
	
	<div class="section_heading">
		<h5>Add Email Management</h5>
	</div>
		
	<div class="main_section bg-b-w">
	
	    <!-------------row----------->
		<div class="row pad_top">
		
			<%-- <div class="col-md-4">
				<label>Select Content Type</label><span class="mandatory_star">*</span>
				<fieldset class="infield">				
					<form:select id="contentType" path="contentType" class="select_option"  >
					<form:option value="-1">Select</form:option>
						<c:forEach items="${contentTypes}" var="content">
							<form:option value="${content.key}">${content.value}</form:option>
						</c:forEach>
					</form:select>		
				</fieldset>
			</div> --%>
			<div class="col-md-4 emailContent">
				<label>Upload Email Template</label><span class="mandatory_star">*</span><br>
				<input type="text" value="" class="uploadFile" placeholder="Choose file" name="uploadFile" id="uploadFile">
				<div class="fileUpload btn ">
					<span class="bg_w_button">Browse</span> 
					<input type="file" class="upload" style="width:100%;" name="ipFileUpload" id="uploadBtn">
				</div>
					 <p style="display:none;color:#FF4000;" id="msg"></p>	
			</div>
				
			<div class="col-md-3 addEmail_upload upload_rate emailContent uploadFile_button">
				<input class="bg_w_button" type="button" value="Upload File" id="uploadfile" onclick="uploadContent('uploadFile','uploadBtn','mytextarea','content')" />						
			</div>
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
	
		<div class="row pad_top emailContent">
			<div class="col-md-4">
				<label>Title of Email Template</label><span class="mandatory_star">*</span>
				<form:input path="name" id="name" class="form-control"  tabindex="1" />
			</div>
			<div class="col-md-4">
				<label>Subject of Email Template</label><span class="mandatory_star">*</span>
				<form:input path="title" id="title"	class="form-control"  tabindex="1" />
			</div>
		</div> 
		<!-------------row----------->
		<div class="row pad_top text_editor">
			<div class='col-md-12 text_editor'>
					<label>Description</label><span class="mandatory_star">*</span>
					<form:textarea id="mytextarea" path="content" tabindex="4"></form:textarea>
					<span class="display_none" style="color:red;">Please enter Content</span>
			</div>
			<!---text editor--->
		</div>
		<!-------------row----------->
	</div>
	<div class="btn_save pull-right">
		<a href="${contextPath}/admin/emailManagement"><input class="bg_g_button" type="button" value="Cancel" /></a>
		<input class="bg_g_button Save_button_error" type="button" value="Save" onclick="addContent();" />
	</div>
	<!----------button----------->
</section>
</form:form>



<script src='https://cdn.tinymce.com/4/tinymce.min.js'></script>
<script>
var contentTypeExist=false;

$(document).ready(function () {
// 	$( ".emailContent" ).hide( "" );
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
		setup : function(ed) {
			ed.on("NodeChange", function(e) {
		    	jQuery("textarea[id='mytextarea']").val(ed.getContent());
		    });
		}
	});

	$.validator.addMethod("dropdowncheck", function(value, element) {
			if(value == "-1"){
				return false;
			} else {
				return true;
			}	
	});

	$.validator.addMethod("textareacheck", function(value, element) {
			value = $('#mytextarea').val();
			if(value.length == 0)
				return false;
			else
				return true;
	});

	$.validator.addMethod('DuplicateCheck', function(value, element) {
		if(contentTypeExist){
			return false;
	    } else {
	    	return true;
	    }
	});

	$("#emailManagementBean").validate({
		 ignore: ".ignore",
		 rules: {
			contentType:{
				dropdowncheck:true,
				DuplicateCheck:true
	        },
	        uploadFile:{
	        	required:true,
            },
            content:{
            	textareacheck:true
			} ,
			title:{
				required:true,
				rangelength:[1,100]
			},
			name:{
				required:true,
				rangelength:[1,100]
			} 
	     },
	     messages: {
	    	 contentType:{
				dropdowncheck:"Please select Content Type",
				DuplicateCheck:"Content Type Already Exist"
			},
			uploadFile:{
				required:"Please upload file"
			},
			content:{
				textareacheck:"Please enter Contents",
	 		},
	 		title:{
	 			required:"Subject of email should not be empty",
	        	 rangelength:"Maximum 100 characters permitted"
	    	 },
	         name:{
	        	 required:"Title of email should not be empty",
	 			rangelength:"Maximum 100 characters permitted"
	 		} 
		 },
		 errorPlacement: function(error, element) {
	        if ($(element).hasClass("uploadFile")) {
	            error.insertAfter($(element).next("div"));
	        } else {
	            error.insertAfter(element);
	        }
	     },
		 errorElement: "div"
	});
	       
	/* $(".select_option").on('selectmenuchange',function() {
		var contentType = $(this).val();
		$.get("${contextPath}/admin/checkContentTypeExist?contentType=" + contentType, function(data, status) {
			if(status == "success" && data != ''){
				contentTypeExist=true;	
			} else {
				contentTypeExist=false;
			}
			$("#emailManagementBean").validate().element('#contentType');
		});
		if(0 == contentType) {
			$( ".emailContent" ).hide( );
		} else {
			$( ".emailContent" ).show( );
		}
	}); */

	$('#uploadBtn').change(function() {
		$('#uploadFile').val(this.value);
		if($('#uploadFile-error').is(":visible") == true) {
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
	}); 
}); 

function uploadContent(valida,id,url,fname){
	var formData = new FormData();
	formData.append('file', $("#" + id)[0].files[0]);
	
	if($("#emailManagementBean").validate().element("#" + valida)){
		$.ajax({
			  url: "${contextPath}/admin/saveUploadContent",
			  data: formData,
			  dataType: 'text',
			  processData: false,
			  contentType: false,
			  type: 'POST',
			  success: function (response) {
				  jQuery("textarea[id='" + url + "']").html(response);
				   $(tinymce.get(url).getBody()).html(response); 
				  $("#mytextarea").val(response);
				  $("#emailManagementBean").validate().element("#mytextarea"); 
			  }
		});
	}
}
$(document).on("keydown", function (e) {
    if ( (e.which === 8) && !$(e.target).is("input, textarea")) {
        e.preventDefault();
    }
});

function addContent(){
	var contentType=$("#contentType").val();
	if(0 == contentType){
		$("#uploadFile").addClass("ignore");
		$("#name").addClass("ignore");
		$("#title").addClass("ignore");
	}
	$("#emailManagementBean").submit();
}
</script>