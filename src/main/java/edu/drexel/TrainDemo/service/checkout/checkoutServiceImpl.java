package edu.drexel.TrainDemo.service.checkout;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import edu.drexel.TrainDemo.service.address.addressService;
import edu.drexel.TrainDemo.service.customer.customerService;
import edu.drexel.TrainDemo.service.order.orderService;
import edu.drexel.TrainDemo.service.payment.paymentService;

public class checkoutServiceImpl implements checkoutService {

	@Autowired
	private orderService orderservice;

	@Autowired
	private customerService customerservice;

	@Autowired
	private paymentService paymentservice;

	@Autowired
	private addressService billingservice;

	@Override
	public void commitOrder(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

}
