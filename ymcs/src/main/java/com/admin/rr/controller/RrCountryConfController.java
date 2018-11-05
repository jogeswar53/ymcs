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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.admin.rr.beans.RrCountryBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrCountryConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrCountryConfController {

	private static final Logger logger = LogManager.getLogger(RrCountryConfController.class.getName());

	@Autowired
	RrCountryConfService countryService;

	@Autowired
	RrCommonService commonService;

	@RequestMapping(value = "/createCountry", method = RequestMethod.GET)
	public String createCountry(ModelMap model, HttpServletRequest request) {

		try {
			String deleteMsg = RrCommonUtils.nullSafe(request.getParameter("deleteMsg"), RrConstants.STRING_EMPTY);
			if (RrConstants.SUCCESS.equals(deleteMsg)) {
				model.addAttribute(RrConstants.SUCCESS_MESSAGE, "Country Deleted Successfully");
			} else if (RrConstants.FAILURE.equals(deleteMsg)) {
				model.addAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
			model.addAttribute("addCountryForm", new RrCountryBean());
			model.addAttribute("countryList", countryService.getAllCountryList());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfController at createCountry(): ", e);
		}

		return "createCountry";
	}

	@RequestMapping(value = "/createCountry", method = RequestMethod.POST)
	public String createCountry(@ModelAttribute("addCountryForm") RrCountryBean countryBean,
			RedirectAttributes redirectAttrs) {

		try {
			if ("updateCountry".equals(countryBean.getAction())) {
				if (RrConstants.SUCCESS.equals(countryService.updateCountry(countryBean))) {
					redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Country updated successfully.");
				} else {
					redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
				}
			} else {
				if (RrConstants.SUCCESS.equals(countryService.createCountry(countryBean))) {
					redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "Country created successfully.");
				} else {
					redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfController at createCountry(-, -): ", e);
		}

		return "redirect:/admin/createCountry?pid=0&mid=3";
	}

	@RequestMapping(value = "/deleteCountry", method = RequestMethod.GET)
	public @ResponseBody String deleteCountry(@RequestParam("countryId") Long countryId) {

		String status = RrConstants.FAILURE;

		try {
			status = countryService.deleteCountryById(countryId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfController at deleteCountry(-): ", e);
		}

		return status;
	}

}
