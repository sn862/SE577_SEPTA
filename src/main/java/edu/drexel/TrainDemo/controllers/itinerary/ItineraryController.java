package edu.drexel.TrainDemo.controllers.itinerary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.service.itinerary.ItineraryService;

@RestController
public class ItineraryController {

	@Autowired
	private ItineraryService itineraryService;
	@GetMapping("/itinerary")
	public String getItenaries() {
		List<Itinerary> itineraries = itineraryService.getItineraries();
		System.out.println(itineraries);
		return itineraries.get(0).getAgency().toString();
	}
}
