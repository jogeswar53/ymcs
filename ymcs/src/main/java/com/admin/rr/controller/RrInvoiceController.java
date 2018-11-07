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

import com.admin.rr.beans.OrderBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.service.RrOrderService;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrInvoiceController {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	RrOrderService orderService;

	private void setDefaultValues(ModelMap model, OrderBean orderBean) {
		try {
			model.addAttribute("addOrderForm", orderBean);
			model.addAttribute("brandMap", orderService.getBrandMap());
			model.addAttribute("issueMap", orderService.getIssueMap());
			model.addAttribute("userMap", orderService.getOnlineUsersMap());
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	

}
