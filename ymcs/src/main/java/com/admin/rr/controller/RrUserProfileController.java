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

import com.admin.rr.beans.RrUserBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrUserProfileConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrUserProfileController {

	private static final Logger logger = LogManager.getLogger(RrUserProfileController.class.getName());

	@Autowired
	RrUserProfileConfService userProfileConfService;

	@Autowired
	RrCommonService commonService;

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createUser(HttpServletRequest request, ModelMap model) {

		Map<String, String> genderMap = new HashMap<>();
		genderMap.put(RrConstants.MALE, RrConstants.MALE);
		genderMap.put(RrConstants.FEMALE, RrConstants.FEMALE);
		genderMap.put(RrConstants.OTHER, RrConstants.OTHER);

		Map<String, String> titleMap = new HashMap<>();
		titleMap.put(RrConstants.MR, RrConstants.MR);
		titleMap.put(RrConstants.MRS, RrConstants.MRS);
		titleMap.put(RrConstants.MS, RrConstants.MS);

		try {
			String deleteMsg = RrCommonUtils.nullSafe(request.getParameter("deleteMsg"), RrConstants.STRING_EMPTY);

			if (RrConstants.SUCCESS.equals(deleteMsg)) {
				model.addAttribute(RrConstants.SUCCESS_MESSAGE, "User Profile Deleted Successfully");
			} else if (RrConstants.FAILURE.equals(deleteMsg)) {
				model.addAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}

			model.addAttribute("addUserProfileForm", new RrUserBean());
			model.addAttribute("userProfileList", userProfileConfService.getAllUserProfiles());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());

			model.addAttribute("genderMap", genderMap);
			model.addAttribute("titleMap", titleMap);

			model.addAttribute("userRoleMap", commonService.getUserRoleMap());
			model.addAttribute("organizationMap", commonService.getOrganizationMap());
			model.addAttribute("countryMap", commonService.getCountryMap());
			model.addAttribute("stateMap", commonService.getStateMap());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileController at createUser(): ", e);
		}

		return "createUser";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("addUserProfileForm") RrUserBean userBean,
			RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(userProfileConfService.createUserProfile(userBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "User Profile created successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileController at createUser(): ", e);
		}

		return "redirect:/admin/createUser?pid=2&mid=10";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("addUserProfileForm") RrUserBean userBean,
			RedirectAttributes redirectAttrs) {

		try {
			if (RrConstants.SUCCESS.equals(userProfileConfService.updateUserProfile(userBean))) {
				redirectAttrs.addFlashAttribute(RrConstants.SUCCESS_MESSAGE, "User Profile updated successfully.");
			} else {
				redirectAttrs.addFlashAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileController at updateUser(): ", e);
		}

		return "redirect:/admin/createUser?pid=2&mid=10";
	}

	@RequestMapping(value = "/studentEnrollment", method = RequestMethod.GET)
	public String studentEnrollment(HttpServletRequest request, ModelMap model) {

		Map<String, String> genderMap = new HashMap<>();
		genderMap.put(RrConstants.MALE, RrConstants.MALE);
		genderMap.put(RrConstants.FEMALE, RrConstants.FEMALE);
		genderMap.put(RrConstants.OTHER, RrConstants.OTHER);

		try {
			String deleteMsg = RrCommonUtils.nullSafe(request.getParameter("deleteMsg"), RrConstants.STRING_EMPTY);

			if (RrConstants.SUCCESS.equals(deleteMsg)) {
				model.addAttribute(RrConstants.SUCCESS_MESSAGE, "User Profile Deleted Successfully");
			} else if (RrConstants.FAILURE.equals(deleteMsg)) {
				model.addAttribute(RrConstants.ERROR_MESSAGE, RrConstants.ERROR_MESSAGE_VALUE);
			}

			model.addAttribute("addUserProfileForm", new RrUserBean());
			model.addAttribute("activeStatus", RrCommonUtils.getStatus());

			model.addAttribute("genderMap", genderMap);

			model.addAttribute("userRoleMap", commonService.getUserRoleMap());
			model.addAttribute("organizationMap", commonService.getOrganizationMap());
			model.addAttribute("countryMap", commonService.getCountryMap());
			model.addAttribute("stateMap", commonService.getStateMap());
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileController at studentEnrollment(): ", e);
		}

		return "studentEnrollment";
	}

	@RequestMapping(value = "/checkDuplicateUserName", method = RequestMethod.GET)
	public @ResponseBody String checkDuplicateUserName(@RequestParam("userName") String userName) {

		String status = RrConstants.FAILURE;

		try {
			status = userProfileConfService.checkDuplicateUserName(userName);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileController at checkDuplicateUserName(-): ", e);
		}

		return status;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public @ResponseBody String deleteUser(@RequestParam("userProfileId") String userProfileId) {

		String status = RrConstants.FAILURE;

		try {
			status = userProfileConfService.deleteUserProfileById(userProfileId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileController at deleteUser(-): ", e);
		}

		return status;
	}

}
