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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.admin.rr.beans.RrOrganizationBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrOrganizationConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrOrganizationConfController {

	private static final Logger logger = LogManager.getLogger(RrOrganizationConfController.class.getName());

	@Autowired
	RrCommonService commonService;

	@Autowired
	RrOrganizationConfService organizationService;

	@RequestMapping(value = "/createOrganization", method = RequestMethod.GET)
	public String createOrganization(HttpServletRequest request, ModelMap model) {

		try {
			model.addAttribute("addOrganizationForm", new RrOrganizationBean());
			model.addAttribute("organizationList", organizationService.getAllOrganizations());
			model.addAttribute("countryMap", commonService.getCountryMap());
			model.addAttribute("stateMap", commonService.getStateMap());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfController at createOrganization(): ", e);
		}

		return "createOrganization";
	}

	@RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
	public String createOrganization(@ModelAttribute("addOrganizationForm") RrOrganizationBean organizationBean,
			RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(organizationService.createOrganization(organizationBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Organization created successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfController at createOrganization(): ", e);
		}

		return "redirect:/admin/createOrganization?pid=2&mid=6";
	}

	@RequestMapping(value = "/updateOrganization", method = RequestMethod.GET)
	public String updateOrganization(ModelMap model, @RequestParam("organizationId") Long organizationId) {

		RrOrganizationBean organizationBean = new RrOrganizationBean();

		try {
			organizationBean = organizationService.getOrganizationById(organizationId);
			model.addAttribute("addOrganizationForm", organizationBean);
			model.addAttribute("countryMap", commonService.getCountryMap());
			model.addAttribute("stateMap", commonService.getStateMap());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfController at updateOrganization(): ", e);
		}

		return "updateOrganization";
	}

	@RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
	public String updateOrganization(@ModelAttribute("addOrganizationForm") RrOrganizationBean organizationBean,
			RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(organizationService.updateOrganization(organizationBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Organization updated successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfController at updateOrganization(): ", e);
		}

		return "redirect:/admin/createOrganization?pid=2&mid=6";
	}

}
