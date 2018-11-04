package com.admin.rr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.admin.rr.beans.RrEmailManagementBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrEmailManagementService;
import com.admin.rr.utils.RrCommonUtils;


@Controller
public class RrEmailManagementController {

	private Logger logger = LogManager.getLogger(RrEmailManagementController.class.getName());

	@Autowired
	RrCommonService commonService;

	@Autowired
	RrEmailManagementService emailManagementService;

	private String emailManagementBean = "emailManagementBean";

	@RequestMapping("/emailManagement")
	public String emailManagement(ModelMap model) {

		List<RrEmailManagementBean> emailBeanList = null;

		try {
			emailBeanList = emailManagementService.getAllEmail();

			model.addAttribute("emailBeanList", emailBeanList);
			model.addAttribute(emailManagementBean, new RrEmailManagementBean());
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrEmailManagementController at emailManagement() :", e);
		}

		return "emailManagement";
	}

	@RequestMapping("/addEmail")
	public String addEmail(ModelMap model, HttpServletRequest request) {

		model.addAttribute(emailManagementBean, new RrEmailManagementBean());
		model.addAttribute("emailStatus", RrCommonUtils.getStatus());

		request.setAttribute("parentMenuId", "2");
		request.setAttribute("menuId", "21");

		return "addEmail";
	}

	@RequestMapping(value = "/addEmail", method = RequestMethod.POST)
	public String addContentSubmit(ModelMap model,
			@ModelAttribute("emailManagementBean") RrEmailManagementBean emailManagementBean,
			HttpServletRequest request) {

		emailManagementBean.setUserId((Integer) request.getSession().getAttribute("userId"));

		try {
			emailManagementService.addEmail(emailManagementBean);
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrEmailManagementController at addContentSubmit() :", e);
		}

		return "redirect:/admin/emailManagement";
	}

	@RequestMapping(value = "/updateEmail", method = RequestMethod.GET)
	public String updateContent(HttpServletRequest request, ModelMap model) {

		model.addAttribute("emailStatus", RrCommonUtils.getStatus());

		try {
			int emid = Integer.parseInt(request.getParameter("emId"));
			RrEmailManagementBean emailManagementBeanTemp = emailManagementService.getEmailById(emid);
			model.addAttribute(emailManagementBean, emailManagementBeanTemp);

			request.setAttribute("parentMenuId", "2");
			request.setAttribute("menuId", "21");
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrEmailManagementController at updateContent() :", e);
		}

		return "updateEmail";
	}

	@RequestMapping(value = "/updateEmail", method = RequestMethod.POST)
	public String updateEmailSubmit(ModelMap model,
			@ModelAttribute("emailManagementBean") RrEmailManagementBean emailManagementBean, HttpServletRequest request,
			RedirectAttributes redirectAttrs) {

		String status = RrConstants.STRING_EMPTY.intern();

		try {
			status = emailManagementService.updateEmail(emailManagementBean);
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrEmailManagementController at updateEmailSubmit() :", e);
		}
		if (RrConstants.SUCCESS.equalsIgnoreCase(status)) {
			redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE.intern(),
					"Email Template Updated Successfully");
		}

		return "redirect:/admin/emailManagement";
	}

	@RequestMapping(value = "/saveUploadContent", method = RequestMethod.POST)
	public @ResponseBody String saveFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		String responseString = RrConstants.STRING_EMPTY.intern();

		try {
			responseString = commonService.getFileContent(file, request);
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrEmailManagementController at saveFile() :", e);
		}

		return responseString;
	}

	@RequestMapping("/checkContentTypeExist")
	public @ResponseBody String contentTypeExist(@RequestParam("contentType") String contentType) {

		return emailManagementService.emailTypeExist(contentType);
	}

}
