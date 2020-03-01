package edu.drexel.TrainDemo.service.itinerary.trip;

import java.util.Date;
import java.util.List;

import edu.drexel.TrainDemo.entities.itinerary.Trip;

public interface TripService {

	List<Trip> getOneWayTrip(String fromCity, String toCity, Date date);

}
