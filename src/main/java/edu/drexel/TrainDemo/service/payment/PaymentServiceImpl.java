package edu.drexel.TrainDemo.service.payment;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.payment.Payment;
import edu.drexel.TrainDemo.entities.payment.PaymentMethod;
import edu.drexel.TrainDemo.repositories.payment.PaymentMethodsRepository;
import edu.drexel.TrainDemo.repositories.payment.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	private PaymentRepository paymentrepo;
	private PaymentMethodsRepository paymentMethodsrepo;

	public PaymentServiceImpl(PaymentRepository paymentrepo,  PaymentMethodsRepository paymentMethodsrepo) {
		super();
		this.paymentrepo = paymentrepo;
		this.paymentMethodsrepo= paymentMethodsrepo;
	}

	@Override
	public Payment getPaymentDetails() {
		return null;

	}

	@Override
	public void processPayment(Payment payment) {
		paymentrepo.save(payment);
	}

	@Override
	public Payment savePaymentDetails(Payment paymentDetails) {
		return paymentrepo.save(paymentDetails);
	}

	@Override
	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethodsrepo.findAll();
	}

	@Override
	public void savePaymentMethods(List<PaymentMethod> methdos) {
		for(PaymentMethod metho: methdos) {
			paymentMethodsrepo.save(metho);
			
		}
	}

	@Override
	public PaymentMethod getPaymentMethod(String code) {
		return paymentMethodsrepo.findById(code).get();
	}

}
