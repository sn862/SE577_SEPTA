package edu.drexel.TrainDemo.controllers.search;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.drexel.TrainDemo.model.Itinerary.OneWayTrip;
import edu.drexel.TrainDemo.model.Itinerary.RoundTrip;
import edu.drexel.TrainDemo.model.Itinerary.Segment;
import edu.drexel.TrainDemo.model.checkout.Checkout;
import edu.drexel.TrainDemo.model.customer.Address;
import edu.drexel.TrainDemo.model.customer.Customer;
import edu.drexel.TrainDemo.model.customer.Passenger;
import edu.drexel.TrainDemo.model.payment.Payment;
import edu.drexel.TrainDemo.model.search.DisplayAvailableItineraries;
import edu.drexel.TrainDemo.model.search.SearchModel;
import edu.drexel.TrainDemo.service.itinerary.ItineraryService;
import edu.drexel.TrainDemo.service.search.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private ItineraryService itineraryService;

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
	public OneWayTrip getOneWayTrip(@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("date") String date) {
		return searchService.getOneWayTrip(fromCity, toCity, date);
	}

	/*
	 * Date must be in String format "dd-MM-yyyy"
	 */
	@GetMapping("/search/getRoundTrip/{fromCity}/{toCity}/{departureDate}/{returnDate}")
	@ResponseBody
	public RoundTrip getRoundTrip(@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("departureDate") String departureDate, @PathVariable("returnDate") String returnDate) {
		return searchService.getRoundTrip(fromCity, toCity, departureDate, returnDate);
	}

	@PostMapping("/search/display.html")
	public String displayItineraries(SearchModel searchModel, Model model) {

		String fromStation = searchModel.getFromStn().substring(searchModel.getFromStn().length() - 4,
				searchModel.getFromStn().length() - 1);
		String toStation = searchModel.getToStn().substring(searchModel.getToStn().length() - 4,
				searchModel.getToStn().length() - 1);

		DisplayAvailableItineraries display = new DisplayAvailableItineraries();
		display.setSearchModel(searchModel);
		display.setOneWayTrip(getOneWayTrip(fromStation, toStation, searchModel.getDepartureDate()));
		model.addAttribute("displayItineraries", display);
		System.out.println(display);
		model.addAttribute("searchModel", searchModel);
		return "display";

	}

	@PostMapping("/search/returndisplay.html")
	public String displayItineraries(@ModelAttribute("display") DisplayAvailableItineraries form, Model model) throws ParseException {
		System.out.println("return trip entry " + form);
		if (isOneWayTrip(form)) {
			return invokeCheckoutpage(form, model);

		} else {
			if (form.getSearchModel().getReturnPrice() != null && form.getSearchModel().getReturnTripId() != null) {
				System.out.println(form);
				return invokeCheckoutpage(form, model);
			} else {
				return invokeReturnTripPage(form, model);
			}

		}

	}

	private String invokeReturnTripPage(DisplayAvailableItineraries form, Model model) {
		String toStation = form.getSearchModel().getFromStn().substring(form.getSearchModel().getFromStn().length() - 4,
				form.getSearchModel().getFromStn().length() - 1);
		String fromStation = form.getSearchModel().getToStn().substring(form.getSearchModel().getToStn().length() - 4,
				form.getSearchModel().getToStn().length() - 1);
		form.setOneWayTrip(getOneWayTrip(fromStation, toStation, form.getSearchModel().getArrivalDate()));

		DisplayAvailableItineraries returnDisplay = new DisplayAvailableItineraries();
		returnDisplay.setSearchModel(form.getSearchModel());
		returnDisplay.setOneWayTrip(getOneWayTrip(fromStation, toStation, form.getSearchModel().getArrivalDate()));
		SearchModel searchModel = new SearchModel();
		searchModel = form.getSearchModel();
		System.out.println(searchModel);
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("displayItineraries", returnDisplay);
		return "returndisplay";
	}

	private String invokeCheckoutpage(DisplayAvailableItineraries form, Model model) throws ParseException {
		Checkout checkout = new Checkout();
		System.out.println(form.getSearchModel());
		checkout.setId(1);
		checkout.setSearchModel(form.getSearchModel());
		Customer customer = new Customer();
		checkout.setCustomer(customer);
		checkout.setBillingAddress(new Address());
		List<Passenger> passengerList = new ArrayList<Passenger>();
		for (int i = 0; i < form.getSearchModel().getNumberOfTickets()-1; i++) {
			Passenger passenger = new Passenger();
			passengerList.add(passenger);
		}
		checkout.setPassengerList(passengerList);
		checkout.setPayment(new Payment());
		System.out.println(checkout);
		model.addAttribute("checkout", checkout);
		model.addAttribute("customer", customer);
		List<Segment> itineraries= new ArrayList<Segment>();
		itineraries.add(itineraryService.getItinerary(form.getSearchModel().getFromStn(), form.getSearchModel().getToStn(), form.getSearchModel().getTripId()));
		if(form.getSearchModel().getTripType().equals("RoundTrip")) {
			itineraries.add(itineraryService.getItinerary(form.getSearchModel().getToStn(), form.getSearchModel().getFromStn(), form.getSearchModel().getReturnTripId()));
		}
		System.out.println(itineraries);
		model.addAttribute("itineraries", itineraries);
		return "checkout";
	}

	private boolean isOneWayTrip(DisplayAvailableItineraries form) {
		System.out.println(form.getSearchModel().getTripType());
		if (form.getSearchModel().getTripType().equals("OneWay")) {
			return true;
		}
		return false;
	}

}
