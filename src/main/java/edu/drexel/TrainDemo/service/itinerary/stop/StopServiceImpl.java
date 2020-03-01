package edu.drexel.TrainDemo.service.itinerary.stop;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.repositories.itinerary.StopRepository;

@Service
public class StopServiceImpl implements StopService {

	public StopServiceImpl(StopRepository stopRepo) {
		super();
		this.stopRepo = stopRepo;
	}

	private StopRepository stopRepo;

	@Override
	public List<Stop> getStops(String searchName) {
		if (findById(searchName) == null || findById(searchName).size() == 0) {
			return stopRepo.findByNameContainingIgnoreCase(searchName);
		} else {
			return findById(searchName);
		}

	}

	private List<Stop> findById(String searchName) {
		return stopRepo.findByIdContainingIgnoreCase(searchName);
	}
}