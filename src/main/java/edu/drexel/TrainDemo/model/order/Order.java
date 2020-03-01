package edu.drexel.TrainDemo.model.order;

import java.util.Optional;

import edu.drexel.TrainDemo.entities.checkout.Address;
import edu.drexel.TrainDemo.entities.checkout.Customer;
import edu.drexel.TrainDemo.entities.checkout.Payment;

public class Order {

	private Optional<Address> billingAddress;
	private Optional<Customer> customer;
	private Optional<Payment> payment;

}
