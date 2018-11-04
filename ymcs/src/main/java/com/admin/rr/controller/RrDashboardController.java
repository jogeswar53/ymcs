package com.admin.rr.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrDashboardController {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboardPage(ModelMap model) {
		logger.info("inside dashboard page");

		return "dashboard";
	}

}
