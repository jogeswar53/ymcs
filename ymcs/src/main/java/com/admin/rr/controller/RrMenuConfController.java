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

import com.admin.rr.beans.RrMenuBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrMenuConfService;
import com.admin.rr.utils.RrCommonUtils;
import com.google.gson.Gson;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrMenuConfController {

	private static final Logger logger = LogManager.getLogger(RrMenuConfController.class.getName());

	@Autowired
	RrMenuConfService menuConfService;

	@Autowired
	RrCommonService commonService;

	@RequestMapping(value = "/createMenu", method = RequestMethod.GET)
	public String createMenus(HttpServletRequest request, ModelMap model) {

		Map<Byte, String> activeStatusValueMap = new HashMap<>();
		activeStatusValueMap.put((byte) 0, "In Active");
		activeStatusValueMap.put((byte) 1, "Active");

		try {
			String deleteMsg = RrCommonUtils.nullSafe(request.getParameter("deleteMsg"), RrConstants.STRING_EMPTY);
			if (RrConstants.SUCCESS.equals(deleteMsg)) {
				model.addAttribute(RrConstants.SUCCESS_MESSAGE, "Menu Deleted Successfully");
			} else if (RrConstants.FAILURE.equals(deleteMsg)) {
				model.addAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
			model.addAttribute("MenuList", new Gson().toJson(menuConfService.getMenuJson()));
			model.addAttribute("activeStatus", activeStatusValueMap);
			model.addAttribute("addMenuForm", new RrMenuBean());
			model.addAttribute("addSubMenuForm", new RrMenuBean());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfController at createMenus(): ", e);
		}

		return "createMenus";
	}

	@RequestMapping(value = "/createMenu", method = RequestMethod.POST)
	public String createMenus(@ModelAttribute("addMenuForm") RrMenuBean testMenuBean,
			RedirectAttributes redirectAttrs) {

		try {
			if ("updateMenu".equals(testMenuBean.getAction())) {
				if (RrConstants.SUCCESS.equals(menuConfService.updateMenu(testMenuBean))) {
					redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Menu Updated Successfully");
				} else {
					redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
				}
			} else {
				if (RrConstants.SUCCESS.equals(menuConfService.createMenu(testMenuBean))) {
					redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Menu Created Successfully");
				} else {
					redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfController at createMenus(-, -): ", e);
		}

		return "redirect:/admin/createMenu?pid=0&mid=2";
	}

	@RequestMapping(value = "/deleteMenu", method = RequestMethod.GET)
	public @ResponseBody String deleteMenu(@RequestParam("menuId") String menuId) {

		String status = RrConstants.FAILURE;

		try {
			status = menuConfService.deleteMenuById(menuId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfController at deleteMenu(-): ", e);
		}

		return status;
	}

}
