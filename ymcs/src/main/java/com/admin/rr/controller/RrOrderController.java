package com.admin.rr.controller;

import java.util.HashMap;
import java.util.Map;

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
public class RrOrderController {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	RrOrderService orderService;

	private static Map<String, String> paymentStatusMap = null;

	private static final String ORDER_FORM = "orderForm";
	private static final String ADD_ORDER_FORM = "addOrderForm";

	private static void setPaymentStatus() {
		if (null == paymentStatusMap) {
			paymentStatusMap = new HashMap<>();
			paymentStatusMap.put("PAID", "Paid");
			paymentStatusMap.put("NOT_PAID", "Not Paid");
		}
	}

	/**
	 * 
	 * @param model
	 * @param orderBean
	 */
	private void setDefaultValues(ModelMap model, OrderBean orderBean) {
		try {
			setPaymentStatus();

			model.addAttribute(ADD_ORDER_FORM, orderBean);
			model.addAttribute("paymentStatusMap", paymentStatusMap);
			model.addAttribute("brandMap", orderService.getBrandMap());
			model.addAttribute("issueMap", orderService.getIssueMap());
			model.addAttribute("userMap", orderService.getOnlineUsersMap());
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
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

	/**
	 * 
	 * @param orderBean
	 * @param model
	 * @return
	 */
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

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewOrders", method = RequestMethod.GET)
	public String getOrder(ModelMap model) {

		try {
			model.addAttribute("orders", orderService.getAllOrders());
		} catch (Exception e) {
			logger.error("", e);
		}

		return "viewOrders";
	}

	/**
	 * 
	 * @param model
	 * @param orderId
	 * @return
	 */
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

	/**
	 * 
	 * @param model
	 * @param orderId
	 * @return
	 */
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

	/**
	 * 
	 * @param model
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/printOrder", method = RequestMethod.GET)
	public String printOrder(ModelMap model, @RequestParam Long orderId) {

		try {
			model.addAttribute(ADD_ORDER_FORM, orderService.getOrder(orderId));
		} catch (Exception e) {
			logger.error("", e);
		}

		return "printOrder";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/workList", method = RequestMethod.GET)
	public String workList(ModelMap model) {

		try {
			model.addAttribute("orders", orderService.getAllOrders());
		} catch (Exception e) {
			logger.error("", e);
		}

		return "workList";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchOrderInvoice", method = RequestMethod.GET)
	public String searchOrderInvoice(ModelMap model) {

		OrderBean orderBean = new OrderBean();

		try {
			model.addAttribute(ORDER_FORM, orderBean);
		} catch (Exception e) {
			logger.error("", e);
		}

		return "searchOrderInvoice";
	}

	/**
	 * 
	 * @param model
	 * @param orderNo
	 * @return
	 */
	@RequestMapping(value = "/searchOrderInvoice", method = RequestMethod.POST)
	public String searchOrderInvoice(ModelMap model, @ModelAttribute(ORDER_FORM) OrderBean orderBean) {

		try {
			if (RrConstants.STRING_EMPTY.equals(orderBean.getAction())) {
				orderBean = orderService.getOrder(orderBean.getOrderNo());
				model.addAttribute(ORDER_FORM, orderBean);
			} else {
				if (!orderService.updateOrderInvoice(orderBean)) {
					model.addAttribute(ORDER_FORM, orderBean);
				} else {
					model.addAttribute(ORDER_FORM, new OrderBean());
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return "searchOrderInvoice";
	}

	/**
	 * 
	 * @param model
	 * @param orderNo
	 * @return
	 */
	@RequestMapping(value = "/searchOrderReceipt", method = RequestMethod.GET)
	public String searchOrderReceipt(ModelMap model) {

		OrderBean orderBean = new OrderBean();

		try {
			model.addAttribute(ORDER_FORM, orderBean);
		} catch (Exception e) {
			logger.error("", e);
		}

		return "searchOrderReceipt";
	}

	/**
	 * 
	 * @param model
	 * @param orderBean
	 * @return
	 */
	@RequestMapping(value = "/searchOrderReceipt", method = RequestMethod.POST)
	public String searchOrderReceipt(ModelMap model, @ModelAttribute(ORDER_FORM) OrderBean orderBean) {

		try {
			if (RrConstants.STRING_EMPTY.equals(orderBean.getAction())) {
				orderBean = orderService.getOrder(orderBean.getOrderNo());
				model.addAttribute(ORDER_FORM, orderBean);
			} else {
				if (!orderService.updateOrderReceipt(orderBean)) {
					model.addAttribute(ORDER_FORM, orderBean);
				} else {
					model.addAttribute(ADD_ORDER_FORM, orderService.getOrder(orderBean.getOrderNo()));

					return "printOrderReceipt";
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return "searchOrderReceipt";
	}

}
