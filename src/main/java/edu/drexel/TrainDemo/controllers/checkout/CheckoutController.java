package edu.drexel.TrainDemo.controllers.checkout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.drexel.TrainDemo.model.checkout.Checkout;
import edu.drexel.TrainDemo.model.checkout.OrderSummary;
import edu.drexel.TrainDemo.model.checkout.SubmitOrder;
import edu.drexel.TrainDemo.service.checkout.CheckoutService;

@Controller
@RequestMapping("/checkout/*")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	@RequestMapping("/submit")
	public OrderSummary checkout(@RequestBody SubmitOrder submitOrder, HttpServletRequest request, HttpServletResponse response) {

		return checkoutService.commitOrder(submitOrder);

	}
	
	@PostMapping("/submitOrder")
	@ResponseBody
	public String submitOrder(@ModelAttribute("checkout") Checkout checkout, Model model) {
		System.out.println(checkout.toString());
		System.out.println("hellooooooooooooooooooooooooo");
		return "hello";

	}

}
