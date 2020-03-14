package edu.drexel.TrainDemo.service.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary2;
import edu.drexel.TrainDemo.model.Itinerary.OneWayTrip;
import edu.drexel.TrainDemo.model.Itinerary.RoundTrip;
import edu.drexel.TrainDemo.model.Itinerary.Segment;

@Service
public interface SearchService {

	List<Itinerary> getItineraries();

	OneWayTrip getOneWayTrip(String fromCity, String toCity, String date);

	List<Stop> getStops(String searchString);

	RoundTrip getRoundTrip(String fromCity, String toCity, String departureDate, String returnDate);
}
