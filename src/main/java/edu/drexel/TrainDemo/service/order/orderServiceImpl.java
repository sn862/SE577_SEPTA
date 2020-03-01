package edu.drexel.TrainDemo.service.order;

import java.util.List;

import edu.drexel.TrainDemo.model.order.Order;
import edu.drexel.TrainDemo.repositories.checkout.AddressRepository;
import edu.drexel.TrainDemo.repositories.checkout.CustomerRepository;
import edu.drexel.TrainDemo.repositories.checkout.PaymentRepository;;

public class orderServiceImpl {

	private AddressRepository address;
	private CustomerRepository customer;
	private PaymentRepository payments;

	private List<Order> commitOrder() {
		return null;

	}

}
