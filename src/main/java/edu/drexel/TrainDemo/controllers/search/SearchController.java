package edu.drexel.TrainDemo.controllers.search;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.service.search.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	
	
	@Autowired
	private SearchService searchService;

	@GetMapping("/getStops/{searchString}")
	public List<Stop> getStops(@PathVariable("searchString") String searchString) {
		return searchService.getStops(searchString);
	}
	
	@GetMapping("/getOneWayTrip/{fromCity}/{toCity}/{date}")
	public List<Trip> getOneWayTrip(@PathVariable("fromCity") String fromCity, @PathVariable("fromCity") String toCity, @PathVariable("date") Date date) {
		return searchService.getOneWayTrip(fromCity, toCity, date);
	}
}
