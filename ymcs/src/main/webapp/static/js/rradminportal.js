var rradminportal = (function() {
	var obj = {
			common : function() {
				$('input[type="text"],input[type="password"]').blur(function(){
					this.value = $.trim(this.value);
				});
				$('.select2').select2();
				$('.alertMessage').delay(5000).fadeOut();
				$('.portal-table').DataTable( {
					"pageLength"    : 20,
					"bDestroy"      : true,
					"searching"     : false,
					"bLengthChange" : false,
					'paging'        : true,
					'lengthChange'  : false,
					'ordering'      : true,
					'info'          : true,
					'autoWidth'     : false
				});
			},
			menu : function(data) {
				$('.menu_list').on('click', '.jstree-anchor', function (e) {
					$(this).jstree(true).toggle_node(e.target);
				}).jstree({
					'core' : {
						'data' : data
					},
				});
				$(document).on('click', '.editMenu', function(){
					$('#homeTab a').removeAttr("data-toggle");
					$('#homeTab a').removeAttr("href");
					$('#homeTab').addClass("disabled");
					$('#homeTab').removeClass("active");

					$('#addMenuTab').addClass("active");
					$('#addMenuTab a').text("Edit Menu");

					$('#addSubMenuTab a').removeAttr("data-toggle");
					$('#addSubMenuTab a').removeAttr("href");
					$('#addSubMenuTab').addClass("disabled");
					$('#addSubMenuTab').removeClass( "active");

					$('#home').addClass('hide');
					$('#addSubMenu').addClass('hide');
					$('#addMenu').show();

					$("#saveMenu").text("Update");
					$("#actionId").val("updateMenu");

					$("#menuIdHidden").val($(this).prev().attr("menuid"));
					$("#menuNameId").val($(this).prev().attr("title"));
					$("#menuDescId").val($(this).prev().attr("menudesc"));
					$("#menuUrlId").val($(this).prev().attr("menuurl"));
					$("#iconUrlId").val($(this).prev().attr("menuiconurl"));
					jQuery("input[name=activeStatus][value="+$(this).prev().attr("status")+"]").attr("checked", "true");
				});
				$(document).on('click','.menu_list .jstree-container-ul li a',function(){
					var title = $(this).attr("title");
					var menulevel = $(this).attr("menulevel");
					$('.icons').remove();

					$(this).after('<i class="fa fa-pencil icons editMenu"></i><i class="fa fa-trash icons deleteContent" data-toggle="modal" data-target="#deleteMenuModel"></i>');

					$("#menuId").html(menulevel);
					$("#menuName").html(title);
					$("#parentName").val(title);
					$("#parentMenuLevel").val(menulevel);

					$("#menuStatus").html($(this).attr("statusvalue"));
					$("#menuStatus").addClass($(this).attr("statusclass"));

					$('#homeTab a').attr("data-toggle", "tab");
					$('#addSubMenuTab a').attr("data-toggle", "tab");

					$('#homeTab a').attr("href", "#home");
					$('#addSubMenuTab a').attr("href", "#addSubMenu");

					$('#homeTab a').attr("aria-expanded", "false");
					$('#addMenuTab a').attr("aria-expanded", "true");
					$('#addSubMenuTab a').attr("aria-expanded", "false");

					$('#addMenu').removeAttr("style");

					if($('#homeTab').hasClass("disabled")) {
						$('#addMenuTab').removeClass("active");
					}

					if((!$('#homeTab').hasClass("active"))
							&& (!$('#addMenuTab').hasClass("active"))
							&& (!$('#addSubMenuTab').hasClass("active"))) {
						$('#homeTab').addClass("active");
					}

					$('#homeTab').removeClass("disabled");
					$('#addSubMenuTab').removeClass("disabled");
					$('#addMenuTab a').text("Add Menu");
					$("#saveMenu").text("Save");

					$('#home').removeClass('hide');
					$('#addSubMenu').removeClass('hide');

					$("#menuIdHidden").val("");
					$("#menuNameId").val("");
					$("#menuDescId").val("");
					$("#menuUrlId").val("");
					$("#iconUrlId").val("");
				});
				$(document).on('click','#deleteMenuId',function() {
					var menuid = $('.menu_list .jstree-clicked').attr("menuid");
					$.get(ctx + "/admin/deleteMenu?menuId=" + menuid,
						function(status) {
							if (status == "success") {
								$('[data-id=' + menuid + ']').remove();
								$('#deleteMenuModel').modal('hide');
								window.location.href = ctx + "/admin/createMenu?pid=2&mid=3&deleteMsg=" + status;
							}
							if (status == "failure") {
								$('[data-id=' + menuid + ']').remove();
								$('#deleteMenuModel').modal('hide');
								window.location.href = ctx + "/admin/createMenu?pid=2&mid=3&deleteMsg=" + status;
							}
						}
					);
				});
				$("#addMenuForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						menuName : {
							required : true,
						},
						menuDesc : {
							required : true,
						},
						menuUrl : {
							required : true,
						},
						iconUrl : {
							required : true
						}
					},
					messages : {
						menuName : {
							required : "Please enter Menu Name",
						},
						menuDesc:{
							required : "Please enter Menu Description"
						},
						menuUrl:{
							required : "Please enter Menu URL"
						},
						iconUrl:{
							required : "Please enter Menu Icon URL"
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#addSubMenuForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						menuName : {
							required : true,
						},
						menuDesc : {
							required : true,
						},
						menuUrl : {
							required : true,
						},
						iconUrl : {
							required : true
						}
					},
					messages : {
						menuName : {
							required : "Please enter Menu Name",
						},
						menuDesc:{
							required : "Please enter Menu Description"
						},
						menuUrl:{
							required : "Please enter Menu URL"
						},
						iconUrl:{
							required : "Please enter Menu Icon URL"
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
			},
			country : function() {
				$("#addCountryForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						countryCode : {
							required : true,
						},
						countryName : {
							required : true,
						},
						currencyCode : {
							required : true,
						},
						currencyName : {
							required : true,
						},
						isdCode : {
							required : true
						}
					},
					messages : {
						countryCode : {
							required : "Please enter Country Code",
						},
						countryName : {
							required : "Please enter Country Name",
						},
						currencyCode:{
							required : "Please enter Currency Code"
						},
						currencyName:{
							required : "Please enter Currency Name"
						},
						isdCode:{
							required : "Please enter ISD Code"
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editCountryForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						countryCode : {
							required : true,
						},
						countryName : {
							required : true,
						},
						currencyCode : {
							required : true,
						},
						currencyName : {
							required : true,
						},
						isdCode : {
							required : true
						}
					},
					messages : {
						countryCode : {
							required : "Please enter Country Code",
						},
						countryName : {
							required : "Please enter Country Name",
						},
						currencyCode:{
							required : "Please enter Currency Code"
						},
						currencyName:{
							required : "Please enter Currency Name"
						},
						isdCode:{
							required : "Please enter ISD Code"
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$(".viewCountry").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var countrycode = $(this).closest('tr').data('countrycode');
					var countryname = $(this).closest('tr').data('countryname');
					var currencycode = $(this).closest('tr').data('currencycode');
					var currencyname = $(this).closest('tr').data('currencyname');
					var isdcode = $(this).closest('tr').data('isdcode');

					$("#viewCountryCode").html(countrycode);
					$("#viewCountryName").html(countryname);
					$("#viewCurrencyCode").html(currencycode);
					$("#viewCurrencyName").html(currencyname);
					$("#viewIsdCode").html(isdcode);

					$('#viewCountryModel').modal({backdrop: 'static', keyboard: false});
					$('#viewCountryModel').data('id', id).modal('show');
				});
				$(".editCountry").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var countrycode = $(this).closest('tr').data('countrycode');
					var countryname = $(this).closest('tr').data('countryname');
					var currencycode = $(this).closest('tr').data('currencycode');
					var currencyname = $(this).closest('tr').data('currencyname');
					var isdcode = $(this).closest('tr').data('isdcode');
					var countryid = $(this).closest('tr').data('countryid');
					var activestatus = $(this).closest('tr').data('activestatus');

					$("#editCountryCode").val(countrycode);
					$("#editCountryName").val(countryname);
					$("#editCurrencyCode").val(currencycode);
					$("#editCurrencyName").val(currencyname);
					$("#editIsdCode").val(isdcode);
					$("#editCountryId").val(countryid);

					jQuery("input[name=editActiveStatus][value="+activestatus+"]").attr("checked", "true");

					$('#editCountryModel').modal({backdrop: 'static', keyboard: false});
					$('#editCountryModel').data('id', id).modal('show');
				});
				$(document).on('click','#deleteCountryId',function() {
					var countryId = $("#delCountryId").val();
					$.get(ctx + "/admin/deleteCountry?countryId=" + countryId,
						function(status) {
							if (status == "success") {
								$('[data-id=' + countryId + ']').remove();
								$('#deleteCountryModel').modal('hide');
								window.location.href = ctx + "/admin/createCountry?pid=2&mid=4&deleteMsg=" + status;
							}
							if (status == "failure") {
								$('[data-id=' + countryId + ']').remove();
								$('#deleteCountryModel').modal('hide');
								window.location.href = ctx + "/admin/createCountry?pid=2&mid=4&deleteMsg=" + status;
							}
						}
					);
				});
				$(".deleteCountry").on("click", function(){
					var countryid = $(this).closest('tr').data('countryid');
					$("#delCountryId").val(countryid);
					$('#deleteCountryModel').modal({backdrop: 'static', keyboard: false});
					$('#deleteCountryModel').data('id', countryid).modal('show');
				});
			},
			state : function() {
				$("#addStateForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						countryCode : {
							required : true,
						},
						stateCode : {
							required : true,
						},
						stateName : {
							required : true,
						}
					},
					messages : {
						countryCode : {
							required : "Please Select Country Code",
						},
						stateCode : {
							required : "Please Enter State Code",
						},
						stateName:{
							required : "Please Enter State Name"
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if($(element).hasClass("form-control select2 select2-hidden-accessible error")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editStateForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						countryCode : {
							required : true,
						},
						stateCode : {
							required : true,
						},
						stateName : {
							required : true,
						}
					},
					messages : {
						countryCode : {
							required : "Please Select Country Code",
						},
						stateCode : {
							required : "Please Enter State Code",
						},
						stateName:{
							required : "Please Enter State Name"
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
			},
			organization : function() {
				$("#addOrganizationForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						countryCode : {
							required : true,
						},
						stateCode : {
							required : true,
						},
						organizationCode : {
							required : true,
						},
						organizationName : {
							required : true,
						},
						organizationAddr1 : {
							required : true,
						},
						organizationAddr2 : {
							required : true,
						},
						organizationAddr3 : {
							required : true,
						},
						district : {
							required : true,
						},
						pincode : {
							required : true,
						}
					},
					messages : {
						countryCode : {
							required : "Please Select Country Name",
						},
						stateCode : {
							required : "Please Select State Name",
						},
						organizationCode : {
							required : "Please Enter Organization Code",
						},
						organizationName : {
							required : "Please Enter OrganizationName",
						},
						organizationAddr1 : {
							required : "Please Enter Organization Address 1",
						},
						organizationAddr2 : {
							required : "Please Enter Organization Address 2",
						},
						organizationAddr3 : {
							required : "Please Enter Organization Address 3",
						},
						district : {
							required : "Please Enter District",
						},
						pincode : {
							required : "Please Enter Pincode",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editOrganizationForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						countryCode : {
							required : true,
						},
						stateCode : {
							required : true,
						},
						organizationCode : {
							required : true,
						},
						organizationName : {
							required : true,
						},
						organizationAddr1 : {
							required : true,
						},
						organizationAddr2 : {
							required : true,
						},
						organizationAddr3 : {
							required : true,
						},
						district : {
							required : true,
						},
						pincode : {
							required : true,
						}
					},
					messages : {
						countryCode : {
							required : "Please Select Country Name",
						},
						stateCode : {
							required : "Please Select State Name",
						},
						organizationCode : {
							required : "Please Enter Organization Code",
						},
						organizationName : {
							required : "Please Enter OrganizationName",
						},
						organizationAddr1 : {
							required : "Please Enter Organization Address 1",
						},
						organizationAddr2 : {
							required : "Please Enter Organization Address 2",
						},
						organizationAddr3 : {
							required : "Please Enter Organization Address 3",
						},
						district : {
							required : "Please Enter District",
						},
						pincode : {
							required : "Please Enter Pincode",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
			},
			classMaster : function() {
				$("#addClassForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						classCode : {
							required : true,
						},
						className : {
							required : true,
						}
					},
					messages : {
						classCode : {
							required : "Please Enter Class Code",
						},
						className : {
							required : "Please Enter Class Name",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editClassForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						classCode : {
							required : true,
						},
						className : {
							required : true,
						}
					},
					messages : {
						classCode : {
							required : "Please Enter Class Code",
						},
						className : {
							required : "Please Enter Class Name",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
			},
			sectionMaster : function() {
				$("#addSectionForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						sectionCode : {
							required : true,
						},
						sectionName : {
							required : true,
						}
					},
					messages : {
						sectionCode : {
							required : "Please Enter Section Code",
						},
						sectionName : {
							required : "Please Enter Section Name",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editSectionForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						sectionCode : {
							required : true,
						},
						sectionName : {
							required : true,
						}
					},
					messages : {
						sectionCode : {
							required : "Please Enter Section Code",
						},
						sectionName : {
							required : "Please Enter Section Name",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
			},
			syllabusMaster : function() {
				$("#addSyllabusForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						classCode : {
							required : true,
						},
						syllabusCode : {
							required : true,
						},
						syllabusName : {
							required : true,
						}
					},
					messages : {
						classCode : {
							required : "Please Select Class Name",
						},
						syllabusCode : {
							required : "Please Enter Syllabus Code",
						},
						syllabusName : {
							required : "Please Enter Syllabus Name",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editSyllabusForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						classCode : {
							required : true,
						},
						syllabusCode : {
							required : true,
						},
						syllabusName : {
							required : true,
						}
					},
					messages : {
						classCode : {
							required : "Please Select Class Name",
						},
						syllabusCode : {
							required : "Please Enter Syllabus Code",
						},
						syllabusName : {
							required : "Please Enter Syllabus Name",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
			},
			createRole : function(data) {
				$('.menu_list').jstree({
					'core' : {
						'data' : data
					},
					"plugins" : [ "checkbox" ]
				});
				$(document).on('click', '.jstree-ocl ', function(e){
					$(this).parent().find("a").removeClass("jstree-clicked");
					e.stopImmediatePropagation();
				});
				$(document).on('click','.menu_list .jstree-container-ul',function(){
					var menuIds = [];
					$(this).find("li").each( function( idx, listItem ) {
						if($(this).find("a").hasClass("jstree-clicked")) {
							menuIds.push($(this).find("a").attr("menuid"));
							$.jstree.reference(this).open_all(this, false, false);
							$(this).find("ul").children("li").each( function( idx, listItem ) {
								if($(this).find("a").hasClass("jstree-clicked")) {
									$.jstree.reference(this).open_all(this, false, false);
									menuIds.push($(this).find("a").attr("menuid"));
								} else {
									$.jstree.reference(this).close_all(this, 10);
								}
							});
						} else {
							$.jstree.reference(this).close_all(this, 10);
						}
					});
					$("#menuId").val(menuIds);
				});
				$("#addUserRoleForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						roleName : {
							required : true,
						},
						roleDesc : {
							required : true,
						}
					},
					messages : {
						roleName : {
							required : "Please enter Role Name",
						},
						roleDesc : {
							required : "Please enter Role Description",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editUserRoleForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						roleName : {
							required : true,
						},
						roleDesc : {
							required : true,
						}
					},
					messages : {
						roleName : {
							required : "Please enter Role Name",
						},
						roleDesc : {
							required : "Please enter Role Description",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$(".viewUserRole").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var countrycode = $(this).closest('tr').data('countrycode');
					var countryname = $(this).closest('tr').data('countryname');
					var currencycode = $(this).closest('tr').data('currencycode');
					var currencyname = $(this).closest('tr').data('currencyname');
					var isdcode = $(this).closest('tr').data('isdcode');

					$("#viewCountryCode").html(countrycode);
					$("#viewCountryName").html(countryname);
					$("#viewCurrencyCode").html(currencycode);
					$("#viewCurrencyName").html(currencyname);
					$("#viewIsdCode").html(isdcode);

					$('#viewCountryModel').modal({backdrop: 'static', keyboard: false});
					$('#viewCountryModel').data('id', id).modal('show');
				});
				$(".editUserRole").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var countrycode = $(this).closest('tr').data('countrycode');
					var countryname = $(this).closest('tr').data('countryname');
					var currencycode = $(this).closest('tr').data('currencycode');
					var currencyname = $(this).closest('tr').data('currencyname');
					var isdcode = $(this).closest('tr').data('isdcode');
					var countryid = $(this).closest('tr').data('countryid');
					var activestatus = $(this).closest('tr').data('activestatus');

					$("#editCountryCode").val(countrycode);
					$("#editCountryName").val(countryname);
					$("#editCurrencyCode").val(currencycode);
					$("#editCurrencyName").val(currencyname);
					$("#editIsdCode").val(isdcode);
					$("#editCountryId").val(countryid);

					jQuery("input[name=editActiveStatus][value="+activestatus+"]").attr("checked", "true");

					$('#editCountryModel').modal({backdrop: 'static', keyboard: false});
					$('#editCountryModel').data('id', id).modal('show');
				});
				$(document).on('click','#deleteUserRoleId',function() {
					var countryId = $("#delUserRoleId").val();
					$.get(ctx + "/admin/deleteUserRole?countryId=" + countryId,
						function(status) {
							if (status == "success") {
								$('[data-id=' + countryId + ']').remove();
								$('#deleteUserRoleModel').modal('hide');
								window.location.href = ctx + "/admin/createUserRole?pid=2&mid=12&deleteMsg=" + status;
							}
							if (status == "failure") {
								$('[data-id=' + countryId + ']').remove();
								$('#deleteUserRoleModel').modal('hide');
								window.location.href = ctx + "/admin/createUserRole?pid=2&mid=12&deleteMsg=" + status;
							}
						}
					);
				});
				$(".deleteUserRole").on("click", function(){
					var countryid = $(this).closest('tr').data('countryid');
					$("#delUserRoleId").val(countryid);
					$('#deleteUserRoleModel').modal({backdrop: 'static', keyboard: false});
					$('#deleteUserRoleModel').data('id', countryid).modal('show');
				});
			},
			createPermission : function(data) {
				$('.menu_list').on('click', '.jstree-anchor', function (e) {
					$(this).jstree(true).toggle_node(e.target);
				}).jstree({
					'core' : {
						'data' : data
					},
					"plugins" : [ "checkbox" ]
				});
				$(document).on('click','.menu_list .jstree-container-ul li a',function(){
					var title = $(this).attr("title");
					var menulevel = $(this).attr("menulevel");
				});
				$("#addPermissionForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						roleId : {
							required : true,
						},
						menuId : {
							required : true,
						}
					},
					messages : {
						roleId : {
							required : "Please select Role Name",
						},
						menuId : {
							required : "Please select menus",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if($(element).hasClass("form-control select2 select2-hidden-accessible error")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editPermissionForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						roleId : {
							required : true,
						},
						menuId : {
							required : true,
						}
					},
					messages : {
						roleId : {
							required : "Please select Role Name",
						},
						menuId : {
							required : "Please select menus",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if($(element).hasClass("form-control select2 select2-hidden-accessible error")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$(".viewPermission").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var countrycode = $(this).closest('tr').data('countrycode');
					var countryname = $(this).closest('tr').data('countryname');
					var currencycode = $(this).closest('tr').data('currencycode');
					var currencyname = $(this).closest('tr').data('currencyname');
					var isdcode = $(this).closest('tr').data('isdcode');

					$("#viewPermissionCode").html(countrycode);
					$("#viewPermissionName").html(countryname);

					$('#viewPermissionModel').modal({backdrop: 'static', keyboard: false});
					$('#viewPermissionModel').data('id', id).modal('show');
				});
				$(".editPermission").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var countrycode = $(this).closest('tr').data('countrycode');
					var countryname = $(this).closest('tr').data('countryname');
					var currencycode = $(this).closest('tr').data('currencycode');
					var currencyname = $(this).closest('tr').data('currencyname');
					var isdcode = $(this).closest('tr').data('isdcode');
					var countryid = $(this).closest('tr').data('countryid');
					var activestatus = $(this).closest('tr').data('activestatus');

					$("#editCountryCode").val(countrycode);
					$("#editCountryName").val(countryname);

					jQuery("input[name=editActiveStatus][value="+activestatus+"]").attr("checked", "true");

					$('#editPermissionModel').modal({backdrop: 'static', keyboard: false});
					$('#editPermissionModel').data('id', id).modal('show');
				});
				$(document).on('click','#deletePermissionId',function() {
					var countryId = $("#delPermissionId").val();
					$.get(ctx + "/admin/deletePermission?countryId=" + countryId,
						function(status) {
							if (status == "success") {
								$('[data-id=' + countryId + ']').remove();
								$('#deletePermissionModel').modal('hide');
								window.location.href = ctx + "/admin/createPermission?pid=2&mid=11&deleteMsg=" + status;
							}
							if (status == "failure") {
								$('[data-id=' + countryId + ']').remove();
								$('#deletePermissionModel').modal('hide');
								window.location.href = ctx + "/admin/createPermission?pid=2&mid=11&deleteMsg=" + status;
							}
						}
					);
				});
				$(".deletePermission").on("click", function(){
					var countryid = $(this).closest('tr').data('countryid');
					$("#delPermissionId").val(countryid);
					$('#deletePermissionModel').modal({backdrop: 'static', keyboard: false});
					$('#deletePermissionModel').data('id', countryid).modal('show');
				});
			},
			createUser : function() {
				//Date picker
				$( "#oldOrgLeavingDate" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#yearOfPassOut0" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseStartDate0" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseEndDate0" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#yearOfPassOut1" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseStartDate1" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseEndDate1" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#yearOfPassOut2" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseStartDate2" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseEndDate2" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#yearOfPassOut3" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseStartDate3" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseEndDate3" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#yearOfPassOut4" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseStartDate4" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#courseEndDate4" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				//Date picker
				$( "#dateOfJoining" ).datepicker({
					dateFormat: 'dd/mm/yy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$( "#dateOfBirth" ).datepicker({
					dateFormat: 'dd/mm/yy',
					maxDate:new Date(),
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$("#addUserProfileForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						userRoleId : {
							required : true,
						},
						organizationId : {
							required : true,
						},
						countryId : {
							required : true,
						},
						stateId : {
							required : true,
						},
						userTitle : {
							required : true,
						},
						firstName : {
							required : true,
						},
						lastName : {
							required : true,
						},
						userId : {
							required : true,
						},
						upassword : {
							required : true,
						},
						gender : {
							required : true,
						},
						emailId : {
							required : true,
						},
						mobileNumber : {
							required : true,
						},
						dateOfBirth : {
							required : true,
						},
						voterIdNo : {
							required : true,
						},
						adharCardNo : {
							required : true,
						},
						guardianName : {
							required : true,
						},
						motherName : {
							required : true,
						}
					},
					messages : {
						userRoleId : {
							required : "Please Select User Role",
						},
						organizationId : {
							required : "Please Select Organization",
						},
						countryId : {
							required : "Please Select Country",
						},
						stateId : {
							required : "Please Select State",
						},
						userTitle : {
							required : "Please Enter Title",
						},
						firstName : {
							required : "Please Enter First Name",
						},
						lastName : {
							required : "Please Enter Last Name",
						},
						userId : {
							required : "Please Enter User ID",
						},
						upassword : {
							required : "Please Enter Password",
						},
						gender : {
							required : "Please Select Gender",
						},
						emailId : {
							required : "Please Enter email id",
						},
						mobileNumber : {
							required : "Please Enter mobile no",
						},
						dateOfBirth : {
							required : "Please select date of birth",
						},
						voterIdNo : {
							required : "Please Enter Voter id no",
						},
						adharCardNo : {
							required : "Please Enter Adhar card no",
						},
						guardianName : {
							required : "Please Enter Guardian Name",
						},
						motherName : {
							required : "Please Enter Mother Name",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if ($(element).hasClass("form-controll")) {
							error.insertAfter($(element).closest("div"));
						} else if($(element).hasClass("form-control select2 select2-hidden-accessible error")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$("#editUserForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						hostelCode : {
							required : true,
						},
						hostelName : {
							required : true,
						},
						hostelAddress : {
							required : true,
						}
					},
					messages : {
						hostelCode : {
							required : "Please Enter Hostel Code",
						},
						hostelName : {
							required : "Please Enter Hostel Name",
						},
						hostelAddress : {
							required : "Please Enter Hostel Address",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
						if($(element).hasClass("form-control")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
				$(".viewUser").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var hostelcode = $(this).closest('tr').data('hostelcode');
					var hostelname = $(this).closest('tr').data('hostelname');

					$("#viewHostelCode").html(hostelcode);
					$("#viewHostelName").html(hostelname);

					$('#viewUserModel').modal({backdrop: 'static', keyboard: false});
					$('#viewUserModel').data('id', id).modal('show');
				});
				$(".editUser").on("click", function(){
					var id = $(this).closest('tr').data('id');
					var hostelcode = $(this).closest('tr').data('hostelcode');
					var hostelname = $(this).closest('tr').data('hostelname');
					var activestatus = $(this).closest('tr').data('activestatus');

					$("#editUserCode").val(hostelcode);
					$("#editUserName").val(hostelname);

					jQuery("input[name=editActiveStatus][value="+activestatus+"]").attr("checked", "true");

					$('#editUserModel').modal({backdrop: 'static', keyboard: false});
					$('#editUserModel').data('id', id).modal('show');
				});
				$(document).on('click','#deleteUserProfileId',function() {
					var userProfileId = $("#delUserProfileId").val();
					$.get(ctx + "/admin/deleteUser?userProfileId=" + userProfileId,
						function(status) {
							if (status == "success") {
								$('[data-id=' + userProfileId + ']').remove();
								$('#deleteUserModel').modal('hide');
								window.location.href = ctx + "/admin/createUser?pid=2&mid=10&deleteMsg=" + status;
							}
							if (status == "failure") {
								$('[data-id=' + userProfileId + ']').remove();
								$('#deleteUserModel').modal('hide');
								window.location.href = ctx + "/admin/createUser?pid=2&mid=10&deleteMsg=" + status;
							}
						}
					);
				});
				$(".deleteUserProfile").on("click", function(){
					var userId = $(this).closest('tr').data('userprofileid');
					$("#delUserProfileId").val(userId);
					$('#deleteUserProfileModel').modal({backdrop: 'static', keyboard: false});
					$('#deleteUserProfileModel').data('id', userId).modal('show');
				});
			},
			order : function() {
				$('#Order_table').DataTable( {
					"pageLength"    : 20,
					"bDestroy"      : true,
					"searching"     : false,
					"bLengthChange" : false,
					'paging'        : true,
					'lengthChange'  : false,
					'ordering'      : true,
					'info'          : true,
					'autoWidth'     : false,
					order: ['0', 'desc']
				});
				$( "#dueTime" ).datepicker({
					dateFormat: 'dd/mm/yyyy',
					minDate: '0',
					showOn: "button",
					buttonImageOnly: true,
					buttonText: "Select date",
					autoclose: true
				});
				$("#addOrderForm").validate({
					onkeyup : false,
					onfocusout: false,
					focusInvalid: false,
					focusCleanup: true,
					ignores:[],
					rules : {
						firstName : {
							required : true,
						},
						mobileNo : {
							required : true,
						},
						brandId : {
							required : true,
						},
						model : {
							required : true,
						},
						userProfileId : {
							required : true,
						},
						issueId : {
							required : true,
						}
					},
					messages : {
						firstName : {
							required : "Please Enter First Name",
						},
						mobileNo : {
							required : "Please Enter Mobile No",
						},
						brandId : {
							required : "Please Select Brand",
						},
						model : {
							required : "Please Enter Model",
						},
						userProfileId : {
							required : "Please Select Assigne To",
						},
						issueId : {
							required : "Please Select an Issue",
						}
					},
					errorElement : "div",
					errorPlacement : function(error, element) {
//						console.log($(element).attr('class'));
						if($(element).hasClass("form-group")) {
							error.insertAfter($(element).next());
						} else if ($(element).hasClass("lft_str")) {
							error.insertAfter($(element).closest("div"));
						} else if ($(element).hasClass("form-control")) {
							error.insertAfter($(element).closest("div"));
						} else if($(element).hasClass("form-control select2 select2-hidden-accessible error")) {
							error.insertAfter($(element).closest("div"));
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					},
				});
			}
	};
	return obj;
})();

function changeURL(controlURL) {
	history.pushState({}, '', ctx + "/" + controlURL);
}
$( document ).scroll(function(){
	$('.datepicker').datepicker('place'); //#modal is the id of the modal
});