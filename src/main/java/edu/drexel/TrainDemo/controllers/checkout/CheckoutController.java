package edu.drexel.TrainDemo.controllers.checkout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.model.checkout.OrderSummary;
import edu.drexel.TrainDemo.model.checkout.SubmitOrder;
import edu.drexel.TrainDemo.service.checkout.CheckoutService;

@RequestMapping("/checkout/*")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	@RequestMapping("/submit")
	public OrderSummary checkout(@RequestBody SubmitOrder submitOrder, HttpServletRequest request, HttpServletResponse response) {

		return checkoutService.commitOrder(submitOrder);

	}

}
