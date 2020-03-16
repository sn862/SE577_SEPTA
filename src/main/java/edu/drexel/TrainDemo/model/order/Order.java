package edu.drexel.TrainDemo.model.order;

import java.util.Optional;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.entities.payment.Payment;

public class Order {

	private Optional<Address> billingAddress;
	private Optional<Customer> customer;
	private Optional<Payment> payment;

	public Optional<Address> getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Optional<Address> billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Optional<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Optional<Customer> customer) {
		this.customer = customer;
	}

	public Optional<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Optional<Payment> payment) {
		this.payment = payment;
	}

}
