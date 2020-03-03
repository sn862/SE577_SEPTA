package edu.drexel.TrainDemo.service.checkout;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.model.checkout.OrderSummary;
import edu.drexel.TrainDemo.model.checkout.SubmitOrder;

@Service
public interface CheckoutService {
	OrderSummary commitOrder(SubmitOrder submitOrder);
}
