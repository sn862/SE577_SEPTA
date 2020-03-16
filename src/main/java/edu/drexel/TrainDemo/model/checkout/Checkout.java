package edu.drexel.TrainDemo.model.checkout;

import java.util.List;

import edu.drexel.TrainDemo.model.customer.Address;
import edu.drexel.TrainDemo.model.customer.Customer;
import edu.drexel.TrainDemo.model.customer.Passenger;
import edu.drexel.TrainDemo.model.payment.Payment;
import edu.drexel.TrainDemo.model.search.SearchModel;

public class Checkout {
	private Customer customer;
	private Address billingAddress;
	private List<Passenger> passengerList;
	private Payment payment;
	private SearchModel searchModel;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public SearchModel getSearchModel() {
		return searchModel;
	}

	public void setSearchModel(SearchModel searchModel) {
		this.searchModel = searchModel;
	}

	@Override
	public String toString() {
		return "Checkout [customer=" + customer + ", billingAddress=" + billingAddress + ", passengerList="
				+ passengerList + ", payment=" + payment + ", searchModel=" + searchModel + "]";
	}

}
