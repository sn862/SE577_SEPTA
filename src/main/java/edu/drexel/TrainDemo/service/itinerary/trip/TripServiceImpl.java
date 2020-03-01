package edu.drexel.TrainDemo.service.itinerary.trip;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.repositories.itinerary.TripRepository;

@Service
public class TripServiceImpl implements TripService {

	private TripRepository tripRepo;

	@Override
	public List<Trip> getOneWayTrip(String fromCity, String toCity, Date date) {
		return tripRepo.findAll();
	}
	
	
}
