package edu.drexel.TrainDemo.controllers.itinerary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.RouteInfo;
import edu.drexel.TrainDemo.service.itinerary.ItineraryService;

@RestController
@RequestMapping("/itinerary/*")
public class ItineraryController {

	@Autowired
	private ItineraryService itineraryService;
	
	
	@GetMapping("/")
	public String getItenaries() {
		List<Itinerary> itineraries = itineraryService.getItineraries();
		System.out.println(itineraries);
		return itineraries.get(0).getAgency().toString();
	}
	
	@PostMapping("/addStop.html")
	public String addStop(@RequestBody Stop stop,HttpServletRequest request, HttpServletResponse response) {
		return itineraryService.addStop(stop).getId();
	}
	
	@GetMapping("/routeInfo")
	public List<Route> getRouteInfo(){
		return itineraryService.getRouteInfo();
	}
	
	@GetMapping("/tripsInfo")
	public List<RouteInfo> getTripInfo(){
		return itineraryService.getTripInfo();
	}
	
	
	
}
