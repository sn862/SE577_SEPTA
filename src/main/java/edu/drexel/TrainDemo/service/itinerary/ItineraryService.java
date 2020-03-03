package edu.drexel.TrainDemo.service.itinerary;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
@Service
public interface ItineraryService {

	List<Itinerary> getItineraries();

	Stop addStop(Stop stop);

	List<Route> getRouteInfo();

	String getTripInfo();

	

}
