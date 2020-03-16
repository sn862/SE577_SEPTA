package edu.drexel.TrainDemo.model.order;

import java.util.List;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.entities.customer.passenger;
import edu.drexel.TrainDemo.entities.itinerary.Itinerary;
import edu.drexel.TrainDemo.entities.order.Orders;
import edu.drexel.TrainDemo.entities.payment.Payment;

public class OrderSummary {

	private Orders order;
	private Customer customer;
	private Address address;
	private List<passenger> passengers;
	private Payment payment;
	private List<Itinerary> itineraries;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<passenger> passengers) {
		this.passengers = passengers;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	@Override
	public String toString() {
		return "OrderSummary [order=" + order + ", customer=" + customer + ", address=" + address + ", passengers="
				+ passengers + ", payment=" + payment + ", itineraries=" + itineraries + "]";
	}

}
