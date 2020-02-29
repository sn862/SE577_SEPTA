package edu.drexel.TrainDemo.controllers.itinerary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.service.itinerary.ItineraryService;
import edu.drexel.TrainDemo.service.itinerary.stop.StopService;

@RestController
public class ItineraryController {

	@Autowired
	private ItineraryService itineraryService;
	
	@Autowired
	private StopService stopService;
	
	
	@GetMapping("/itinerary")
	public String getItenaries() {
		List<Itinerary> itineraries = itineraryService.getItineraries();
		System.out.println(itineraries);
		return itineraries.get(0).getAgency().toString();
	}
	
	@GetMapping("/getStops/{searchName}")
	public List<Stop> getStopsbyName(@PathVariable("searchName") String searchName){
		System.out.println("hello");
		System.out.println(searchName);
		System.out.println( stopService.getStops(searchName));
		return stopService.getStops(searchName);
	}
}
