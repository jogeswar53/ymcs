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

	private static final String ORG_FORM = "addOrganizationForm";

	@RequestMapping(value = "/createOrganization", method = RequestMethod.GET)
	public String createOrganization(HttpServletRequest request, ModelMap model) {

		try {
			model.addAttribute(ORG_FORM, new RrOrganizationBean());
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
	public String createOrganization(@ModelAttribute(ORG_FORM) RrOrganizationBean organizationBean,
			RedirectAttributes redirectAttrs, ModelMap model) {

		try {
			if (organizationService.createOrganization(organizationBean)) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Organization created successfully.");
			} else {
				model.addAttribute(ORG_FORM, organizationBean);
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);

				return "createOrganization";
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
			model.addAttribute(ORG_FORM, organizationBean);
			model.addAttribute("countryMap", commonService.getCountryMap());
			model.addAttribute("stateMap", commonService.getStateMap());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfController at updateOrganization(): ", e);
		}

		return "updateOrganization";
	}

	@RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
	public String updateOrganization(@ModelAttribute(ORG_FORM) RrOrganizationBean organizationBean,
			RedirectAttributes redirectAttrs, ModelMap model) {

		try {
			if (organizationService.updateOrganization(organizationBean)) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Organization updated successfully.");
			} else {
				model.addAttribute(ORG_FORM, organizationBean);
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);

				return "updateOrganization";
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfController at updateOrganization(): ", e);
		}

		return "redirect:/admin/createOrganization?pid=2&mid=6";
	}

}
