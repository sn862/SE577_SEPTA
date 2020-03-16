package edu.drexel.TrainDemo.service.checkout;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.entities.itinerary.Itinerary;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;
import edu.drexel.TrainDemo.entities.order.Orders;
import edu.drexel.TrainDemo.entities.payment.Payment;
import edu.drexel.TrainDemo.model.checkout.Checkout;
import edu.drexel.TrainDemo.model.order.OrderSummary;
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
			PaymentService paymentservice, ItineraryService itineraryservice) {
		super();
		this.orderservice = orderservice;
		this.customerservice = customerservice;
		this.paymentservice = paymentservice;
		this.itineraryservice = itineraryservice;
	}

	@Override
	public OrderSummary commitOrder(Checkout checkout) {

		List<Itinerary> listOfItinerary = new ArrayList();
		Customer customer = new Customer();
		Address address = new Address();
		Payment payment = new Payment();
		Orders orderDetails = new Orders();
		Itinerary itinerary = new Itinerary();
		Itinerary returnItinerary = new Itinerary();
		OrderSummary ordersummary = new OrderSummary();

		if (checkout != null && checkout.getCustomer() != null) {
			customer = new Customer(checkout.getCustomer().getFirstName(), checkout.getCustomer().getLastName(),
					checkout.getCustomer().getAge(), checkout.getCustomer().getEmail(),
					checkout.getCustomer().getContactNumber());
			customer = customerservice.saveCustomer(customer);
			ordersummary.setCustomer(customer);
		}

		if (checkout != null && checkout.getBillingAddress() != null) {
			address = new Address(checkout.getBillingAddress().getStrtAddressLine1(),
					checkout.getBillingAddress().getStrrAddressLine2(), checkout.getBillingAddress().getCity(),
					checkout.getBillingAddress().getState(), checkout.getBillingAddress().getCountry(),
					checkout.getBillingAddress().getZipcode(), customer.getId());
			address = customerservice.saveAddressDetails(address);
			ordersummary.setAddress(address);
		}
		double totalPrice=0.0;
		if(checkout.getSearchModel().getReturnPrice() != null) {
			totalPrice= checkout.getSearchModel().getPrice() + checkout.getSearchModel().getReturnPrice();
			
		}else {
			totalPrice=  checkout.getSearchModel().getPrice();
		}
		if (checkout != null && checkout.getPayment() != null) {
			payment = new Payment(checkout.getPayment().getPaymentType(), checkout.getPayment().getCname(),
					checkout.getPayment().getCnum(), checkout.getPayment().getMonth(), checkout.getPayment().getYear(),
					checkout.getPayment().getCvv(),totalPrice , customer.getId(),
					address.getId());

			payment = paymentservice.savePaymentDetails(payment);
			ordersummary.setPayment(payment);
		}

		if (checkout != null && checkout.getPassengerList() != null) {

			ordersummary.setPassengers(customerservice.savePassengers(checkout.getPassengerList(), customer.getId()));

		}

		if (checkout != null && checkout.getSearchModel() != null) {

			String fromStationCode = checkout.getSearchModel().getFromStn().substring(
					checkout.getSearchModel().getFromStn().length() - 4,
					checkout.getSearchModel().getFromStn().length() - 1);

			String toStationCode = checkout.getSearchModel().getToStn().substring(
					checkout.getSearchModel().getToStn().length() - 4,
					checkout.getSearchModel().getToStn().length() - 1);

			orderDetails = new Orders(customer.getId(), payment.getId(), checkout.getSearchModel().getNumberOfTickets(),
					checkout.getSearchModel().getPrice(), checkout.getSearchModel().getReturnPrice());
			ordersummary.setOrder(orderservice.submitOrder(orderDetails));

			StopTime StopTimeDep = itineraryservice.getStopTimeByTripIdandStnCode(
					new StopTimeIdClass(fromStationCode, checkout.getSearchModel().getTripId()));

			StopTime StopTimeArr = itineraryservice.getStopTimeByTripIdandStnCode(
					new StopTimeIdClass(toStationCode, checkout.getSearchModel().getTripId()));

			itinerary = new Itinerary(checkout.getSearchModel().getFromStn(), checkout.getSearchModel().getToStn(),
					checkout.getSearchModel().getPrice(), checkout.getSearchModel().getTripId(),
					orderDetails.getOrderId(), checkout.getSearchModel().getDepartureDate(),
					StopTimeDep.getDeparture_time(), StopTimeArr.getArrival_time());

			itinerary = itineraryservice.saveItinerary(itinerary);
			listOfItinerary.add(itinerary);

			if (checkout.getSearchModel().getTripType().equals("RoundTrip")) {

				StopTime StopTimeDepRound = itineraryservice.getStopTimeByTripIdandStnCode(
						new StopTimeIdClass(toStationCode, checkout.getSearchModel().getTripId()));

				StopTime StopTimeArrRound = itineraryservice.getStopTimeByTripIdandStnCode(
						new StopTimeIdClass(fromStationCode, checkout.getSearchModel().getTripId()));

				returnItinerary = new Itinerary(checkout.getSearchModel().getToStn(),
						checkout.getSearchModel().getFromStn(), checkout.getSearchModel().getReturnPrice(),
						checkout.getSearchModel().getTripId(), orderDetails.getOrderId(),
						checkout.getSearchModel().getArrivalDate(), StopTimeDepRound.getDeparture_time(),
						StopTimeArrRound.getArrival_time());

				returnItinerary = itineraryservice.saveItinerary(returnItinerary);

				listOfItinerary.add(returnItinerary);

			}

		}
		ordersummary.setItineraries(listOfItinerary);

		return ordersummary;
	}

}
