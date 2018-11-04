package com.admin.rr.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.rr.beans.RrAdminUserBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrLoginService;

@Controller
public class RrAdminLoginController {

	private static final Logger logger = LogManager.getLogger(RrAdminLoginController.class.getName());

	private String loginView = "admin/login/adminLogin";

	@Autowired
	RrLoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String adminLoginpage(ModelMap model, HttpServletRequest request) {
		model.addAttribute("adminUserBean", new RrAdminUserBean());
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		return loginView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogindetailsCheck(@ModelAttribute("adminUserBean") RrAdminUserBean adminUserBean,
			HttpServletRequest request, ModelMap model) {

		RrAdminUserBean userBean = null;
		String errorMsg = RrConstants.STRING_EMPTY.intern();

		try {
			userBean = loginService.authenticateUser(adminUserBean);

			errorMsg = userBean.getErrorMsg();
			errorMsg = (null != errorMsg) ? errorMsg.trim() : RrConstants.STRING_EMPTY.intern();
			if (errorMsg.length() > 0) {
				model.addAttribute("errorMsg", errorMsg);

				return loginView;
				// return "redirect:/admin/dashboard?pid=0&mid=1";
			} else {
				request.getSession().setAttribute("activeUser", userBean);
			}
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrAdminLoginController at adminLogindetailsCheck() :", e);
		}

		return "redirect:/admin/dashboard?pid=0&mid=1";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request) {
		try {
			if (request.getSession() != null) {
				request.getSession().invalidate();
			}
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrAdminLoginController at logoutPage() :", e);
		}

		return "redirect:/admin/login";
	}

}
