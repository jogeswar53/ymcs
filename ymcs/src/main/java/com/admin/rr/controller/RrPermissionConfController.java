package com.admin.rr.controller;

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

import com.admin.rr.beans.RrPermissionBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrMenuConfService;
import com.admin.rr.service.RrPermissionConfService;
import com.admin.rr.utils.RrCommonUtils;
import com.google.gson.Gson;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrPermissionConfController {

	private static final Logger logger = LogManager.getLogger(RrPermissionConfController.class.getName());

	@Autowired
	RrPermissionConfService permissionConfService;

	@Autowired
	RrCommonService commonService;

	@Autowired
	RrMenuConfService menuConfService;

	@RequestMapping(value = "/createPermission", method = RequestMethod.GET)
	public String createPermission(ModelMap model) {

		try {
			model.addAttribute("addPermissionForm", new RrPermissionBean());
			model.addAttribute("MenuList", new Gson().toJson(menuConfService.getMenuJson()));
			model.addAttribute("permissionList", permissionConfService.getAllPermissionList());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
			model.addAttribute("roleMap", commonService.getUserRoleMap());
			model.addAttribute("menuMap", permissionConfService.getMenuMap());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfController at createPermission(-): ", e);
		}

		return "createPermission";
	}

	@RequestMapping(value = "/createPermission", method = RequestMethod.POST)
	public String createPermission(@ModelAttribute("addPermissionForm") RrPermissionBean permissionBean,
			RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(permissionConfService.createPermission(permissionBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Permission created successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfController at createPermission(-,-): ", e);
		}

		return "redirect:/admin/createPermission?pid=2&mid=11";
	}

	@RequestMapping(value = "/updatePermission", method = RequestMethod.GET)
	public String updatePermission(ModelMap model, @RequestParam("permissionId") Integer permissionId) {

		RrPermissionBean permissionBean = new RrPermissionBean();

		try {
			permissionBean = permissionConfService.getPermissionById(permissionId);
			model.addAttribute("addPermissionForm", permissionBean);
			model.addAttribute("MenuList", new Gson().toJson(menuConfService.getMenuJson()));
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
			model.addAttribute("roleMap", commonService.getUserRoleMap());
			model.addAttribute("menuMap", permissionConfService.getMenuMap());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfController at updatePermission(-): ", e);
		}

		return "updatePermission";
	}

	@RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
	public String updatePermission(@ModelAttribute("addPermissionForm") RrPermissionBean permissionBean,
			RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(permissionConfService.updatePermission(permissionBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Permission updated successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfController at updatePermission(-,-): ", e);
		}

		return "redirect:/admin/createPermission?pid=2&mid=11";
	}

	@RequestMapping(value = "/deletePermission", method = RequestMethod.GET)
	public @ResponseBody String deletePermission(@RequestParam("permissionId") Integer permissionId) {

		String status = RrConstants.FAILURE;

		try {
			status = permissionConfService.deletePermissionById(permissionId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfController at deletePermission(-): ", e);
		}

		return status;
	}

}
