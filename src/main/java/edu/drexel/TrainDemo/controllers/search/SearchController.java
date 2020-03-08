package edu.drexel.TrainDemo.controllers.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.drexel.TrainDemo.model.Itinerary.Journey;
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
        System.out.println("welcome");
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
		String fromStation= model.getFromStn().substring(model.getFromStn().length()-4, model.getFromStn().length()-1);
		String toStation= model.getToStn().substring(model.getToStn().length()-4, model.getToStn().length()-1);
		System.out.println("heeee");
		modelrequest.addAttribute("request", model);
		if(model.getTripType().equals("OneWay")){
			modelrequest.addAttribute("forward", getOneWayTrip(fromStation, toStation, model.getDepartureDate()));
		}else {
			modelrequest.addAttribute("forward", getOneWayTrip(fromStation, toStation, model.getDepartureDate()));
			modelrequest.addAttribute("return", getOneWayTrip(toStation, fromStation, model.getArrivalDate()));
		}
		System.out.println(getOneWayTrip(fromStation, toStation, model.getDepartureDate()));
		return "display";
		
	}	
	
}
