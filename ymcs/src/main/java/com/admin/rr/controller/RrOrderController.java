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
import com.admin.rr.service.RrOrderService;

/**
 * @author jogeswarsahu
 *
 */
@Controller
public class RrOrderController {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	RrOrderService orderService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		try {
			model.addAttribute("addOrderForm", new OrderBean());
			model.addAttribute("brandMap", orderService.getBrandMap());
			model.addAttribute("userMap", orderService.getOnlineUsersMap());
		} catch (Exception e) {
			logger.error("", e);
		}

		return "createOrder";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String createPage(@ModelAttribute("OrderBean") OrderBean orderBean) {

		try {
			// Default implementation is ignored.
		} catch (Exception e) {
			logger.error("", e);
		}

		return "redirect:/admin/printOrder?orderId=1";
	}

	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	public String getOrder(@RequestParam String value) {

		try {
			// Default implementation is ignored.
		} catch (Exception e) {
			logger.error("", e);
		}

		return "";
	}

	@RequestMapping(value = "/printOrder", method = RequestMethod.GET)
	public String printOrder(@RequestParam Long orderId) {

		try {
			// Default implementation is ignored.
		} catch (Exception e) {
			logger.error("", e);
		}

		return "printOrder";
	}

}
