<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<section class="insurance_management">
	<div id="breadcrumb">
		<ul>
			<li>Home</li>
			<li>Configuration</li>
			<li>Email Management</li>
<!-- 			<li>Content/Email Management</li> -->
		</ul>
	</div>
	<!---breadcrumb--->
	<div class="section_heading">
		<span>Email Template Listing</span>
		<a class="bg_w_button" href="${contextPath}/admin/addEmail" >Add Email</a>
<!-- 		<a class="bg_w_button" style="cursor:pointer" >Add Email</a> -->
		
		<div class="updated_msg" >
			<c:if test="${fn:length(successMsg) gt 0}">
			<div id="msg" class="alertMessage" style="color:green;font-weight: bold;">
					<c:out value="${successMsg}"></c:out> 
				</div>
			</c:if>
		</div>
	</div>

	<div class="management"><!---Email Management--->
	
		<div class="tab-content">
			<div id="sectionA" class="tab-pane fade in active" ><!----- Email Template Listing ---->
				
				<div class="insurance_policy_table action_border table_width">
					<table class=" table table-bordered" cellspacing="0" cellpadding="0" width="100%">
						<thead>
							<c:if test="${emailBeanList.size() gt 0}"> 
								<tr>
									<th class="name">Sl No.</th>
									<th>Email Title</th>
									<th>Subject</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
							</c:if>
						</thead>
						<!----thead--->
						<tbody>
							<c:if test="${emailBeanList.size() eq 0}"><h2 align="center" style="color:blue;">No Data Available</h2> </c:if>
					  		<c:forEach items="${emailBeanList}" var="content" varStatus="i">
					   			<tr class="admin" data-id="${content.emId }" data-name="${content.emId}">
					   				<td >${i.count}</td>
					       			<td>${content.name}</td>
							 		<td>${content.title}</td>
							 		<c:if test="${content.emailStatus eq 0}">
							 			<td class="red">Inactive</td>
									</c:if>
							 		<c:if test="${content.emailStatus eq 1}">
							 			<td class="green">Active</td>
									</c:if>
									<td>
										<a href="${contextPath}/admin/updateEmail?emId=${content.emId}">
											<img src="${contextPath}/static/img/edit_icon.png" class="edit_wraper"></img>
										</a>
						   			</td>
					   			</tr>
				   			</c:forEach>
						</tbody><!---tbody--->
					</table><!---table-->
				</div>
			</div>
		</div><!-- tab-content end -->
	</div><!-- management end -->

</section>

<script src='https://cdn.tinymce.com/4/tinymce.min.js'></script>


<script type="text/javascript">
$(window).load(function(){
	setTimeout(function(){
		$('.section_heading .updated_msg').fadeOut()
	}, 3000);
});

$(document).ready(function () {
	
	tinymce.init({
		selector: 'textarea#mytextarea',
		height: '200px',
        theme: 'modern',
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
				}
     },
     messages: {
    	 
    	 title:{
        	 required:"Title field should not be empty",
        	 rangelength:"Maximum 100 characters permitted"
    	 },
    	 
         name:{
 			required:"Name field should not be empty",
 			rangelength:"Maximum 100 characters permitted"
 		},
 		content:{
			required:"Please enter some content",
		}
     },
      errorElement: "div",
      submitHandler: function (form) {
             form.submit();
     },
     //onfocusout: function(element) { $(element).valid(); }
  });

 	$('#uploadBtn').change(function() {
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
	}); 
}); 

function uploadContent(valida,id,url,fname){
	var formData = new FormData();
	formData.append('file',$("#"+id)[0].files[0]);
	
	if($("#emailManagementBean").validate().element("#"+valida)){
		$.ajax({
			  url: "${contextPath}/admin/saveUploadContent",
			  data: formData,
			  dataType: 'text',
			  processData: false,
			  contentType: false,
			  type: 'POST',
			  success: function (response) {
				jQuery("textarea[id='"+url+"']").html(response);
				$(tinymce.get(url).getBody()).html(response); 
				$("#mytextarea").val(response);
				$("#emailManagementBean").validate().element("#mytextarea");
			  }
		});
	}
}

$(document).on("keydown", function (e) {
    if (e.which === 8 && !$(e.target).is("input, textarea")) {
        e.preventDefault();
    }
});




</script>