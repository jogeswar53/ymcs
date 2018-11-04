package com.admin.rr.controller;

import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.admin.rr.beans.RrAdminUserBean;
import com.admin.rr.beans.RrUserRoleBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrMenuConfService;
import com.admin.rr.service.RrUserRoleConfService;
import com.admin.rr.utils.RrCommonUtils;
import com.google.gson.Gson;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrUserRoleConfController {

	private static final Logger logger = LogManager.getLogger(RrUserRoleConfController.class.getName());

	@Autowired
	RrUserRoleConfService userRoleConfService;

	@Autowired
	RrCommonService commonService;

	@Autowired
	RrMenuConfService menuConfService;

	@RequestMapping(value = "/createUserRole", method = RequestMethod.GET)
	public String createUserRole(ModelMap model) {

		Map<String, String> userType = new HashMap<>();
		userType.put(RrConstants.SUPER_ADMIN, RrConstants.SUPER_ADMIN);
		userType.put(RrConstants.ADMIN, RrConstants.ADMIN);
		userType.put(RrConstants.EMLOYEE, RrConstants.EMLOYEE);

		try {
			model.addAttribute("addUserRoleForm", new RrUserRoleBean());
			model.addAttribute("MenuList", new Gson().toJson(menuConfService.getMenuJson()));
			model.addAttribute("userRoleList", userRoleConfService.getAllUserRoleList());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
			model.addAttribute("userTypes", userType);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfController at createUserRole(-): ", e);
		}

		return "createUserRole";
	}

	@RequestMapping(value = "/createUserRole", method = RequestMethod.POST)
	public String createUserRole(@ModelAttribute("addUserRoleForm") RrUserRoleBean userRoleBean,
			RedirectAttributes redirectAttrs, HttpServletRequest request) {

		RrAdminUserBean userBean = null;

		try {
			userBean = (RrAdminUserBean) request.getSession().getAttribute("activeUser");

			if (null != userBean) {
				if (RrConstants.SUCCESS
						.equals(userRoleConfService.createUserRole(userRoleBean, userBean.getUserProfileDetailsId()))) {
					redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "User role created successfully.");
				} else {
					redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfController at createUserRole(POST): ", e);
		}

		return "redirect:/admin/createUserRole?pid=2&mid=12";
	}

	@RequestMapping(value = "/updateUserRole", method = RequestMethod.GET)
	public String updateUserRole(ModelMap model, @RequestParam("userRoleId") Long userRoleId) {

		RrUserRoleBean userRoleBean = new RrUserRoleBean();

		Map<String, String> userType = new HashMap<>();
		userType.put(RrConstants.SUPER_ADMIN, RrConstants.SUPER_ADMIN);
		userType.put(RrConstants.ADMIN, RrConstants.ADMIN);
		userType.put(RrConstants.EMLOYEE, RrConstants.EMLOYEE);

		try {
			userRoleBean = userRoleConfService.getUserRoleById(userRoleId);
			model.addAttribute("addUserRoleForm", userRoleBean);
			model.addAttribute("MenuList", new Gson().toJson(menuConfService.getMenuJson()));
			model.addAttribute("userRoleList", userRoleConfService.getAllUserRoleList());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
			model.addAttribute("userTypes", userType);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfController at updateUserRole(-): ", e);
		}

		return "updateUserRole";
	}

	@RequestMapping(value = "/updateUserRole", method = RequestMethod.POST)
	public String updateUserRole(@ModelAttribute("addUserRoleForm") RrUserRoleBean userRoleBean,
			RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(userRoleConfService.updateUserRole(userRoleBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "User role updated successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfController at updateUserRole(POST): ", e);
		}

		return "redirect:/admin/createUserRole?pid=2&mid=12";
	}

	@RequestMapping(value = "/deleteUserRole", method = RequestMethod.GET)
	public @ResponseBody String deleteUserRole(@RequestParam("userRoleId") Long userRoleId) {

		String status = RrConstants.FAILURE;

		try {
			status = userRoleConfService.deleteUserRoleById(userRoleId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfController at deleteUserRole(-): ", e);
		}

		return status;
	}

}
