package edu.drexel.TrainDemo.service.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.entities.payment.Payment;
import edu.drexel.TrainDemo.model.checkout.Checkout;
import edu.drexel.TrainDemo.model.checkout.OrderSummary;
import edu.drexel.TrainDemo.service.customer.CustomerService;
import edu.drexel.TrainDemo.service.itinerary.ItineraryService;
import edu.drexel.TrainDemo.service.order.OrderService;
import edu.drexel.TrainDemo.service.payment.PaymentService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private OrderService orderservice;

	@Autowired
	private CustomerService customerservice;

	@Autowired
	private PaymentService paymentservice;

	@Autowired
	private ItineraryService itineraryservice;

	public CheckoutServiceImpl(OrderService orderservice, CustomerService customerservice,
			PaymentService paymentservice) {
		super();
		this.orderservice = orderservice;
		this.customerservice = customerservice;
		this.paymentservice = paymentservice;
	}

	@Override
	public OrderSummary commitOrder(Checkout checkout) {

		Customer customer = new Customer(checkout.getCustomer().getFirstName(), checkout.getCustomer().getLastName(),
				checkout.getCustomer().getAge(), checkout.getCustomer().getEmail(),
				checkout.getCustomer().getContactNumber());

		Customer customerentity = customerservice.saveCustomer(customer);

		Address address = new Address(checkout.getBillingAddress().getStrtAddressLine1(),
				checkout.getBillingAddress().getStrrAddressLine2(), checkout.getBillingAddress().getCity(),
				checkout.getBillingAddress().getState(), checkout.getBillingAddress().getCountry(),
				checkout.getBillingAddress().getZipcode(), customer.getId());

		Address addressId = customerservice.saveAddressDetails(address);

		Payment payment = new Payment(checkout.getPayment().getPaymentType(), checkout.getPayment().getCname(),
				checkout.getPayment().getCnum(), checkout.getPayment().getMonth(), checkout.getPayment().getYear(),
				checkout.getPayment().getCvv(), checkout.getPayment().getPrice(), customer.getId(), addressId.getId());
		System.out.println("..........");
		System.out.println(checkout.getSearchModel().getPrice());

		Long paymentId = paymentservice.savePaymentDetails(payment);

		System.out.println("..Itinearies List..");
		System.out.println(checkout.getSearchModel());
		customerservice.savePassengers(checkout.getPassengerList(), customer.getId());

//	customer --> address --> passengers --> payment --> order --> iternary
//	
//	passenger customer

//		order --> customer id, payment details, itineary,

//		Customer customer = customerservice.getCustomerDetails();
//		customerservice.updateCustomerDetails(customer);
//		customerservice.updateBillingDetails(new Address());
//		paymentservice.processPayment(new Payment());
//		Order order = orderservice.submitOrder(new Order());
//
//		OrderSummary summary = orderservice.getOrderSummary(order);

		return null;
	}

}
