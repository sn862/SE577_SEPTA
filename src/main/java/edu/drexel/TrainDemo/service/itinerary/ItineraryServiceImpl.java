package edu.drexel.TrainDemo.service.itinerary;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.Utils.Utils;
import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.ReadableStopTime;
import edu.drexel.TrainDemo.model.Itinerary.RouteInfo;
import edu.drexel.TrainDemo.model.Itinerary.Segment;
import edu.drexel.TrainDemo.repositories.itinerary.AgencyRepository;
import edu.drexel.TrainDemo.repositories.itinerary.ItineraryRepository;
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
	private ItineraryRepository itineraryRepo;

	public ItineraryServiceImpl(AgencyRepository agencyRepository, RouteRepository routeRepository,
			StopRepository stopRepo, TripRepository tripRepo, StopTimeRepository stopTimeRepo,
			ItineraryRepository itineraryRepo) {
		super();
		this.agencyRepository = agencyRepository;
		this.routeRepository = routeRepository;
		this.stopRepo = stopRepo;
		this.tripRepo = tripRepo;
		this.stopTimeRepo = stopTimeRepo;
		this.itineraryRepo = itineraryRepo;
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

		List<Trip> trips = tripRepo.findAll();
		for (Trip trip : trips) {

			Optional<Route> route = routeRepository.findById(trip.getRoute_id());
			List<StopTime> stopTimes = stopTimeRepo.findByTripIdOrderByStopSequence(trip.getId());
			List<ReadableStopTime> readableStopTimes = new ArrayList<ReadableStopTime>();
			for (StopTime stopTime : stopTimes) {

				readableStopTimes.add(new ReadableStopTime(stopTime.getStopId(), stopTime.getDeparture_time()));
			}
			routeInfoList.add(new RouteInfo(route.get().getId(), route.get().getName(), readableStopTimes));
		}
		return routeInfoList;
	}

	@Override
	public Segment getItinerary(String fromStn, String toStn, String tripId) throws ParseException {
		Segment segment = new Segment();
		StopTime fromStation = stopTimeRepo.findById(new StopTimeIdClass(fromStn.substring(fromStn.length()-4, fromStn.length()-1), Long.parseLong(tripId))).get();
		StopTime toStation = stopTimeRepo.findById(new StopTimeIdClass(toStn.substring(toStn.length()-4, toStn.length()-1), Long.parseLong(tripId))).get();
		segment.setDepartureStation(fromStation);
		segment.setArrivalStation(toStation);
		segment.setDuration(Utils.calculateDuration(toStation.getArrival_time(), fromStation.getDeparture_time()));
		segment.setTripId(Long.parseLong(tripId));
		segment.setRoute(routeRepository.findById(tripRepo.findById(Long.parseLong(tripId)).get().getRoute_id()).get());
		
		return segment;
	}
	
	public StopTime getStopTimeByTripIdandStnCode(StopTimeIdClass stopTimeIdClass) {

		return stopTimeRepo.findById(stopTimeIdClass).get();
	}

	@Override
	public edu.drexel.TrainDemo.entities.itinerary.Itinerary saveItinerary(
			edu.drexel.TrainDemo.entities.itinerary.Itinerary itinerary) {

		return itineraryRepo.save(itinerary);
	}

}
