package edu.drexel.TrainDemo.service.payment;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.payment.Payment;
import edu.drexel.TrainDemo.repositories.payment.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	private PaymentRepository paymentrepo;
	

	public PaymentServiceImpl(PaymentRepository paymentrepo) {
		super();
		this.paymentrepo = paymentrepo;
	}

	public Payment getPaymentDetails() {
		return null;

	}

	@Override
	public void processPayment(Payment payment) {
		paymentrepo.save(payment);
	}

}
