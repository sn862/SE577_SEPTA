package edu.drexel.TrainDemo.service.payment;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.payment.Payment;

@Service
public interface PaymentService {

	Payment getPaymentDetails();

	void processPayment(Payment payment);

	Payment savePaymentDetails(Payment payment);

}
