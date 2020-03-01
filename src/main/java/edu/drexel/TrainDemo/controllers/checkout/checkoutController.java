package edu.drexel.TrainDemo.controllers.checkout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.service.checkout.checkoutService;

public class checkoutController {

	@Autowired
	private checkoutService checkoutService;

	@RequestMapping("/checkout")
	public void checkout(HttpServletRequest request, HttpServletResponse response) {

		checkoutService.commitOrder(request);

	}

}
