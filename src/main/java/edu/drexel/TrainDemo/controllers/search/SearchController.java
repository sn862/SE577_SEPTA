package edu.drexel.TrainDemo.controllers.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.model.Itinerary.Journey;
import edu.drexel.TrainDemo.service.search.SearchService;

@RestController
@RequestMapping("/search/*")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@GetMapping("/getStops/{searchString}")
	public String getStops(@PathVariable("searchString") String searchString) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(searchService.getStops(searchString));
		return json;
	}

	/*
	 * Date must be in String format "dd-MM-yyyy"
	 */
	@GetMapping("/getOneWayTrip/{fromCity}/{toCity}/{date}")
	public List<Journey> getOneWayTrip(@PathVariable("fromCity") String fromCity, @PathVariable("toCity") String toCity,
			@PathVariable("date") String date) {
		return searchService.getOneWayTrip(fromCity, toCity, date);
	}

	/*
	 * Date must be in String format "dd-MM-yyyy"
	 */
	@GetMapping("/getRoundTrip/{fromCity}/{toCity}/{departureDate}/{returnDate}")
	public ArrayList<List<Journey>> getRoundTrip(@PathVariable("fromCity") String fromCity,
			@PathVariable("toCity") String toCity, @PathVariable("departureDate") String departureDate,
			@PathVariable("returnDate") String returnDate) {
		return searchService.getRoundTrip(fromCity, toCity, departureDate, returnDate);
	}
}
