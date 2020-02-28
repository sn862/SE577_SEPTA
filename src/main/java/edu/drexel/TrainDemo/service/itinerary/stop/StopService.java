package edu.drexel.TrainDemo.service.itinerary.stop;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
@Service
public interface StopService {

	List<Stop> getStops(String searchName);

}
