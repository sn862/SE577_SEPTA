package edu.drexel.TrainDemo.service.itinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.ReadableStopTime;
import edu.drexel.TrainDemo.model.Itinerary.RouteInfo;
import edu.drexel.TrainDemo.repositories.itinerary.AgencyRepository;
import edu.drexel.TrainDemo.repositories.itinerary.RouteRepository;
import edu.drexel.TrainDemo.repositories.itinerary.StopRepository;
import edu.drexel.TrainDemo.repositories.itinerary.StopTimeRepository;
import edu.drexel.TrainDemo.repositories.itinerary.TripRepository;
@Service
public class ItineraryServiceImpl implements ItineraryService {

	private AgencyRepository agencyRepository;
	private RouteRepository routeRepository;
	private StopRepository stopRepo;
	private TripRepository tripRepo;
	private StopTimeRepository stopTimeRepo;
	

	

	public ItineraryServiceImpl(AgencyRepository agencyRepository, RouteRepository routeRepository,
			StopRepository stopRepo, TripRepository tripRepo, StopTimeRepository stopTimeRepo) {
		super();
		this.agencyRepository = agencyRepository;
		this.routeRepository = routeRepository;
		this.stopRepo = stopRepo;
		this.tripRepo = tripRepo;
		this.stopTimeRepo = stopTimeRepo;
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
	public List<RouteInfo> getTripInfo() {
		List<RouteInfo> routeInfoList = new ArrayList<RouteInfo>();
		
		List<Trip> trips= tripRepo.findAll();
		for(Trip trip:trips) {
			
			Optional<Route> route= routeRepository.findById(trip.getRoute_id());
			List<StopTime> stopTimes = stopTimeRepo.findByTripIdOrderByStopSequence(trip.getId());
			List<ReadableStopTime> readableStopTimes = new ArrayList<ReadableStopTime>();
			for(StopTime stopTime: stopTimes) {
				
				readableStopTimes.add(new ReadableStopTime(stopTime.getStopId(), stopTime.getDeparture_time()));
			}
			routeInfoList.add(new RouteInfo(route.get().getId(), route.get().getName(), readableStopTimes));
		}
		return routeInfoList;
	}
	
}
