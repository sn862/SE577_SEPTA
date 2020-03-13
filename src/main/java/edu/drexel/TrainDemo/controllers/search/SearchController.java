package edu.drexel.TrainDemo.controllers.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.drexel.TrainDemo.controllers.checkout.CheckoutController;
import edu.drexel.TrainDemo.model.Itinerary.Journey;
import edu.drexel.TrainDemo.model.checkout.Checkout;
import edu.drexel.TrainDemo.model.customer.Address;
import edu.drexel.TrainDemo.model.customer.Customer;
import edu.drexel.TrainDemo.model.customer.Passenger;
import edu.drexel.TrainDemo.model.payment.Payment;
import edu.drexel.TrainDemo.model.search.Display;
import edu.drexel.TrainDemo.model.search.FowardForm;
import edu.drexel.TrainDemo.model.search.SearchModel;
import edu.drexel.TrainDemo.service.search.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping("/")
	public String home(Model model) {
		SearchModel searchModel = new SearchModel();
		searchModel.setTripType("OneWay");
		searchModel.setNumberOfTickets(1);

		model.addAttribute("search", searchModel);
		return "index";
	}

	@GetMapping("/search/getStops/{searchString}")
	@ResponseBody
	public String getStops(@PathVariable("searchString") String searchString) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(searchService.getStops(searchString));
		return json;
	}

	/*
	 * Date must be in String format "dd-MM-yyyy"
	 */
	@GetMapping("/search/getOneWayTrip/{fromCity}/{toCity}/{date}")
	@ResponseBody
	public List<Journey> getOneWayTrip(@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("date") String date) {
		return searchService.getOneWayTrip(fromCity, toCity, date);
	}

	/*
	 * Date must be in String format "dd-MM-yyyy"
	 */
	@GetMapping("/search/getRoundTrip/{fromCity}/{toCity}/{departureDate}/{returnDate}")
	@ResponseBody
	public ArrayList<List<Journey>> getRoundTrip(@PathVariable("fromCity") String fromCity,
			@PathVariable("toCity") String toCity, @PathVariable("departureDate") String departureDate,
			@PathVariable("returnDate") String returnDate) {
		return searchService.getRoundTrip(fromCity, toCity, departureDate, returnDate);
	}

	@PostMapping("/search/display.html")
	public String displayItineraries(SearchModel model, Model modelrequest) {

		String fromStation = model.getFromStn().substring(model.getFromStn().length() - 4,
				model.getFromStn().length() - 1);
		String toStation = model.getToStn().substring(model.getToStn().length() - 4, model.getToStn().length() - 1);
		Display display = new Display();
		display.setSearchModel(model);
		display.setJournyList(getOneWayTrip(fromStation, toStation, model.getDepartureDate()));

		modelrequest.addAttribute("display", display);
		modelrequest.addAttribute("searchModel", model);
		return "display";

	}

	@PostMapping("/search/returndisplay.html")
	public String displayItineraries(@ModelAttribute("display") Display form, Model model) {
		if (isOneWayTrip(form)) {
			return invokeCheckoutpage(form, model);

		} else {
			if (form.getSearchModel().getReturnPrice() != null && form.getSearchModel().getReturnTripId() != null) {
				return invokeCheckoutpage(form, model);
			} else {
				return invokeReturnTripPage(form, model);
			}

		}

	}

	private String invokeReturnTripPage(Display form, Model model) {
		System.out.println(form.getSearchModel());
		String toStation = form.getSearchModel().getFromStn().substring(form.getSearchModel().getFromStn().length() - 4,
				form.getSearchModel().getFromStn().length() - 1);
		String fromStation = form.getSearchModel().getToStn().substring(form.getSearchModel().getToStn().length() - 4,
				form.getSearchModel().getToStn().length() - 1);
		form.setReturnJournyList(getOneWayTrip(fromStation, toStation, form.getSearchModel().getArrivalDate()));
		Display returnDisplay = new Display();
		returnDisplay.setSearchModel(form.getSearchModel());
		returnDisplay
				.setReturnJournyList(getOneWayTrip(fromStation, toStation, form.getSearchModel().getArrivalDate()));
		SearchModel searchModel = new SearchModel();
		searchModel = form.getSearchModel();
		System.out.println(searchModel);
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("display", returnDisplay);
		return "returndisplay";
	}

	private String invokeCheckoutpage(Display form, Model model) {
		Checkout checkout = new Checkout();
		checkout.setId(1);
		checkout.setSearchModel(form.getSearchModel());
		Customer customer = new Customer();
		customer.setFirstName("hello");
		checkout.setCustomer(customer);
		checkout.setBillingAddress(new Address());
		List<Passenger> passengerList = new ArrayList<Passenger>();
		for (int i = 0; i < form.getSearchModel().getNumberOfTickets(); i++) {
			Passenger passenger = new Passenger();
			passengerList.add(passenger);
		}
		checkout.setPassengerList(passengerList);
		checkout.setPayment(new Payment());
		System.out.println(checkout);
		model.addAttribute("checkout", checkout);
		model.addAttribute("customer", customer);
		return "checkout";
	}

	private boolean isOneWayTrip(Display form) {
		System.out.println(form.getSearchModel().getTripType());
		if (form.getSearchModel().getTripType().equals("OneWay")) {
			return true;
		}
		return false;
	}

}
