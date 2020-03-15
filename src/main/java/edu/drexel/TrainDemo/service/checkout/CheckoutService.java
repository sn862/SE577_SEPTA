package edu.drexel.TrainDemo.service.checkout;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.model.checkout.Checkout;
import edu.drexel.TrainDemo.model.checkout.OrderSummary;

@Service
public interface CheckoutService {
	OrderSummary commitOrder(Checkout checkout);
}
