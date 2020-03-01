package edu.drexel.TrainDemo.service.customer;

import java.util.List;

import edu.drexel.TrainDemo.entities.checkout.Customer;
import edu.drexel.TrainDemo.repositories.checkout.CustomerRepository;

public class customerServiceImpl {

	private CustomerRepository customer;

	List<Customer> getCustomerDetails() {

		return (List<Customer>) customer.findAll();

	}
}
