package edu.drexel.TrainDemo.service.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.repositories.itinerary.AgencyRepository;
import edu.drexel.TrainDemo.repositories.itinerary.RouteRepository;
import edu.drexel.TrainDemo.repositories.itinerary.StopRepository;
import edu.drexel.TrainDemo.repositories.itinerary.StopTimeRepository;
import edu.drexel.TrainDemo.repositories.itinerary.TripRepository;
@Service
public class SearchServiceImpl implements SearchService {

	private AgencyRepository agencyRepository;
	private RouteRepository routeRepository;
	private StopRepository stopRepository;
	private StopTimeRepository stopTimeRepository;
	private TripRepository tripRepository;
	
	
	@Override
	public List<Itinerary> getItineraries() {
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		Itinerary itinerary = new Itinerary();
		
		
		itinerary.setAgency(agencyRepository.findById((long) 99));
		itinerary.setRoute(routeRepository.findById((long) 11317));
		System.out.println(agencyRepository.findById((long) 99));
		itineraries.add(itinerary);
		return itineraries;
	}


	@Override
	public List<Trip> getOneWayTrip(String fromCity, String toCity, Date date) {
		return tripRepository.findAll();
	}
	


	@Override
	public List<Stop> getStops(String searchName) {
		if (findById(searchName) == null || findById(searchName).size() == 0) {
			return stopRepository.findByNameContainingIgnoreCase(searchName);
		} else {
			return findById(searchName);
		}

	}

	private List<Stop> findById(String searchName) {
		return stopRepository.findByIdContainingIgnoreCase(searchName);
	}
}
