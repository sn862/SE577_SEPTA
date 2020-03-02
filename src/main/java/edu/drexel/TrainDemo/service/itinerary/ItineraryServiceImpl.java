package edu.drexel.TrainDemo.service.itinerary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.repositories.itinerary.AgencyRepository;
import edu.drexel.TrainDemo.repositories.itinerary.RouteRepository;
import edu.drexel.TrainDemo.repositories.itinerary.StopRepository;
import edu.drexel.TrainDemo.repositories.itinerary.TripRepository;
@Service
public class ItineraryServiceImpl implements ItineraryService {

	private AgencyRepository agencyRepository;
	private RouteRepository routeRepository;
	private StopRepository stopRepo;
	private TripRepository tripRepo;

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

	@Override
	public Stop addStop(Stop stop) {
		return stopRepo.save(stop);
	}

	@Override
	public List<Route> getRouteInfo() {
		return (List<Route>) routeRepository.findAll();
	}

	@Override
	public String getTripInfo() {
		List<Trip> trips= tripRepo.findAll();
		return null;
	}
	
}
