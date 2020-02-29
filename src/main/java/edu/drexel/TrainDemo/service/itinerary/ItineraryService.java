package edu.drexel.TrainDemo.service.itinerary;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
@Service
public interface ItineraryService {

	List<Itinerary> getItineraries();

}
