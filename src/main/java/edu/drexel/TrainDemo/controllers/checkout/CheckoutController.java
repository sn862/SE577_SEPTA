package edu.drexel.TrainDemo.controllers.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.drexel.TrainDemo.model.checkout.Checkout;
import edu.drexel.TrainDemo.model.order.OrderSummary;
import edu.drexel.TrainDemo.service.checkout.CheckoutService;

@Controller
@RequestMapping("/checkout/*")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	@PostMapping("/submitOrder")
	public String submitOrder(@ModelAttribute("checkout") Checkout checkout, Model model) {
		OrderSummary orderSummary = checkoutService.commitOrder(checkout);
		System.out.println(orderSummary);
		model.addAttribute("orderSummary", orderSummary);
		return "confirmation";

	}

}
