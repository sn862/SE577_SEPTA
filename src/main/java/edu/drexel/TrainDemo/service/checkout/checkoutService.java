package edu.drexel.TrainDemo.service.checkout;

import javax.servlet.http.HttpServletRequest;

public interface checkoutService {
	void commitOrder(HttpServletRequest request);
}
