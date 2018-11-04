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

import com.admin.rr.beans.RrStateBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrStateConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrStateConfController {

	private static final Logger logger = LogManager.getLogger(RrStateConfController.class.getName());

	@Autowired
	RrStateConfService stateConfService;

	@Autowired
	RrCommonService commonService;

	@RequestMapping(value = "/createState", method = RequestMethod.GET)
	public String createState(ModelMap model) {

		try {
			model.addAttribute("addStateForm", new RrStateBean());
			model.addAttribute("countryMap", commonService.getCountryMap());
			model.addAttribute("stateList", stateConfService.getAllStateList());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfController at createState(GET): ", e);
		}

		return "createState";
	}

	@RequestMapping(value = "/createState", method = RequestMethod.POST)
	public String createState(@ModelAttribute("addStateForm") RrStateBean stateBean, RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(stateConfService.createState(stateBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "State created successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfController at createState(POST): ", e);
		}

		return "redirect:/admin/createState?pid=2&mid=5";
	}

	@RequestMapping(value = "/updateState", method = RequestMethod.GET)
	public String updateState(ModelMap model, @RequestParam("stateId") Long stateId) {

		RrStateBean stateBean = new RrStateBean();

		try {
			stateBean = stateConfService.getStateById(stateId);
			model.addAttribute("addStateForm", stateBean);
			model.addAttribute("countryMap", commonService.getCountryMap());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfController at updateState(GET): ", e);
		}

		return "updateState";
	}

	@RequestMapping(value = "/updateState", method = RequestMethod.POST)
	public String updateState(@ModelAttribute("addStateForm") RrStateBean stateBean, RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(stateConfService.updateState(stateBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "State updated successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfController at updateState(POST): ", e);
		}

		return "redirect:/admin/createState?pid=2&mid=5";
	}

	@RequestMapping(value = "/deleteState", method = RequestMethod.GET)
	public @ResponseBody String deleteState(@RequestParam("stateId") Long stateId) {

		String status = RrConstants.FAILURE;

		try {
			status = stateConfService.deleteStateById(stateId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfController at deleteState(-): ", e);
		}

		return status;
	}

}
