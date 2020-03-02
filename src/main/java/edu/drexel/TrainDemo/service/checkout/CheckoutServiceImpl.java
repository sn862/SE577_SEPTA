package edu.drexel.TrainDemo.service.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.entities.payment.Payment;
import edu.drexel.TrainDemo.model.checkout.OrderSummary;
import edu.drexel.TrainDemo.model.checkout.SubmitOrder;
import edu.drexel.TrainDemo.model.order.Order;
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
	public OrderSummary commitOrder(SubmitOrder submitOrder) {
		Customer customer = customerservice.getCustomerDetails();
		customerservice.updateCustomerDetails(customer);
		customerservice.updateBillingDetails(new Address());
		paymentservice.processPayment(new Payment());
		Order order = orderservice.submitOrder(new Order());

		OrderSummary summary = orderservice.getOrderSummary(order);

		return summary;
	}

}
