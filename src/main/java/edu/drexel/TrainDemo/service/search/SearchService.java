package edu.drexel.TrainDemo.service.search;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;

@Service
public interface SearchService {

	List<Itinerary> getItineraries();

	List<Trip> getOneWayTrip(String fromCity, String toCity, Date date);

	List<Stop> getStops(String searchString);
}
