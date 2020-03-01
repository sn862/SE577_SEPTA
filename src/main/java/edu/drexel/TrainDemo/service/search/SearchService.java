package edu.drexel.TrainDemo.service.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.Journey;

@Service
public interface SearchService {

	List<Itinerary> getItineraries();

	List<Journey> getOneWayTrip(String fromCity, String toCity, String date);

	List<Stop> getStops(String searchString);

	ArrayList<List<Journey>> getRoundTrip(String fromCity, String toCity, String departureDate, String returnDate);
}
