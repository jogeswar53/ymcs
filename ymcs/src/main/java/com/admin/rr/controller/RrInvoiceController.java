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

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String createPage(ModelMap model) {

		OrderBean orderBean = new OrderBean();

		try {
			setDefaultValues(model, orderBean);
		} catch (Exception e) {
			logger.error("", e);
		}

		return "createOrder";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String createPage(@ModelAttribute("OrderBean") OrderBean orderBean, ModelMap model) {

		try {
			if (RrConstants.STRING_EMPTY.equals(orderBean.getAction())) {
				// create record
				if (!orderService.saveOrder(orderBean)) {
					setDefaultValues(model, orderBean);

					return "createOrder";
				}
			} else {
				// update record
				if (!orderService.updateOrder(orderBean)) {
					setDefaultValues(model, orderBean);

					return "updateOrder";
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return "redirect:/admin/viewOrders?pid=12&mid=13";
		// return "redirect:/admin/printOrder?orderId=1";
	}

	@RequestMapping(value = "/viewOrders", method = RequestMethod.GET)
	public String getOrder(ModelMap model) {

		try {
			model.addAttribute("orders", orderService.getAllOrders());
		} catch (Exception e) {
			logger.error("", e);
		}

		return "viewOrders";
	}

	@RequestMapping(value = "/updateOrder", method = RequestMethod.GET)
	public String updateOrder(ModelMap model, @RequestParam Long orderId) {

		OrderBean orderBean = null;

		try {
			orderBean = orderService.getOrder(orderId);

			setDefaultValues(model, orderBean);
		} catch (Exception e) {
			logger.error("", e);
		}

		return "updateOrder";
	}

	@RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(ModelMap model, @RequestParam Long orderId) {

		OrderBean orderBean = null;

		try {
			orderBean = orderService.getOrder(orderId);

			setDefaultValues(model, orderBean);
		} catch (Exception e) {
			logger.error("", e);
		}

		return "viewOrder";
	}

	@RequestMapping(value = "/printOrder", method = RequestMethod.GET)
	public String printOrder(ModelMap model, @RequestParam Long orderId) {

		try {
			model.addAttribute("addOrderForm", orderService.getOrder(orderId));
		} catch (Exception e) {
			logger.error("", e);
		}

		return "printOrder";
	}

	@RequestMapping(value = "/workList", method = RequestMethod.GET)
	public String workList(ModelMap model) {

		try {
			model.addAttribute("orders", orderService.getAllOrders());
		} catch (Exception e) {
			logger.error("", e);
		}

		return "workList";
	}

}
