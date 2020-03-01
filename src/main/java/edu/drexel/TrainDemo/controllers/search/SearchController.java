package edu.drexel.TrainDemo.controllers.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Journey;
import edu.drexel.TrainDemo.service.search.SearchService;

@RestController
public class SearchController {

	@Autowired
	private SearchService searchService;

	@GetMapping("/getStops/{searchString}")
	public List<Stop> getStops(@PathVariable("searchString") String searchString) {
		return searchService.getStops(searchString);
	}

	@GetMapping("/getOneWayTrip/{fromCity}/{toCity}/{date}")
	public List<Journey> getOneWayTrip(@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("date") String date) {
		return searchService.getOneWayTrip(fromCity, toCity, date);
	}

	@GetMapping("/getRoundTrip/{fromCity}/{toCity}/{departureDate}/{returnDate}")
	public ArrayList<List<Journey>> getRoundTrip(@PathVariable("fromCity") String fromCity,
			@PathVariable("toCity") String toCity, @PathVariable("departureDate") String departureDate,
			@PathVariable("returnDate") String returnDate) {
		return searchService.getRoundTrip(fromCity, toCity, departureDate, returnDate);
	}
}
