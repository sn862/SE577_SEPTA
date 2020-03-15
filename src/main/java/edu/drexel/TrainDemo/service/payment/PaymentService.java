package edu.drexel.TrainDemo.service.payment;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.payment.Payment;
import edu.drexel.TrainDemo.entities.payment.PaymentMethod;

@Service
public interface PaymentService {

	Payment getPaymentDetails();

	void processPayment(Payment payment);

	Payment savePaymentDetails(Payment payment);

	List<PaymentMethod> getPaymentMethods();

	void savePaymentMethods(List<PaymentMethod> methdos);

	PaymentMethod getPaymentMethod(String code);

}
