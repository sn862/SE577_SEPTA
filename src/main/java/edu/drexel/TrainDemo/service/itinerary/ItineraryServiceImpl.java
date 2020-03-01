package edu.drexel.TrainDemo.service.itinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Agency;
import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.repositories.itinerary.AgencyRepository;
import edu.drexel.TrainDemo.repositories.itinerary.RouteRepository;
@Service
public class ItineraryServiceImpl implements ItineraryService {

	private AgencyRepository agencyRepository;
	private RouteRepository routeRepository;

	public ItineraryServiceImpl(AgencyRepository agencyRepository, RouteRepository routeRepository) {
		super();
		this.agencyRepository = agencyRepository;
		this.routeRepository = routeRepository;
	}

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
	
}
