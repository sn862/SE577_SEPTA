package edu.drexel.TrainDemo.service.search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

import javax.validation.ReportAsSingleViolation;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Calendar;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.Journey;
import edu.drexel.TrainDemo.repositories.itinerary.AgencyRepository;
import edu.drexel.TrainDemo.repositories.itinerary.CalendarRepository;
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
	private CalendarRepository calendarRepo;
	Map<Integer, String> map = new HashMap<Integer, String>();
	
	

	public SearchServiceImpl(AgencyRepository agencyRepository, RouteRepository routeRepository,
			StopRepository stopRepository, StopTimeRepository stopTimeRepository, TripRepository tripRepository,
			CalendarRepository caldendarRepo) {
		super();
		this.agencyRepository = agencyRepository;
		this.routeRepository = routeRepository;
		this.stopRepository = stopRepository;
		this.stopTimeRepository = stopTimeRepository;
		this.tripRepository = tripRepository;
		this.calendarRepo= caldendarRepo;
		map.put(0, "Sunday");
		map.put(1, "Monday");
		map.put(2, "Tuesday");
		map.put(3, "Wednesday");
		map.put(4, "Thursday");
		map.put(5, "Friday");
		map.put(6, "Saturday");
		
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
	public List<Journey> getOneWayTrip(String fromCity, String toCity, String date) {
		List<Journey> journeys = new ArrayList<Journey>();
		List<StopTime> fromStations = filterTripsBydate(fromCity, date);
		for (StopTime fromTime : fromStations) {
			Optional<StopTime> toTime = stopTimeRepository.findById(new StopTimeIdClass(toCity, fromTime.getTripId()));
			if (toTime.isPresent() && (fromTime.getStop_sequence() < toTime.get().getStop_sequence())) {
				journeys.add(constructJourney(fromTime, toTime));
			} else {

			}
		}
		return journeys;
	}

	private List<StopTime> filterTripsBydate(String fromCity, String date) {
		List<StopTime> fromStationsNewList = new ArrayList<StopTime>();
		List<StopTime> fromStations = stopTimeRepository.findByStopId(fromCity);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		int day =0;
		try {
			Date date1 = format.parse(date);
			day = date1.getDay();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (StopTime stopTime : fromStations) {
			Optional<Trip> trip = tripRepository.findById(stopTime.getTripId());
			Optional<Calendar> calendar = calendarRepo.findById(trip.get().getCalendar_id());
			if(calendar.get().valueListOfDays().get(day)) {
				fromStationsNewList.add(stopTime);
			}
		}
		return fromStations;
	}

	private Journey constructJourney(StopTime fromTime, Optional<StopTime> toTime) {
		Journey journey= new Journey();
		journey.setFromStaionCode(fromTime.getStopId());
		journey.setFromStationName(stopRepository.findById(fromTime.getStopId()).get().getName());
		journey.setToStationCode(toTime.get().getStopId());
		journey.setToStationName(stopRepository.findById(toTime.get().getStopId()).get().getName());
		journey.setDepartureTime(fromTime.getDeparture_time());
		journey.setArrivalTime(toTime.get().getArrival_time());
		journey.setRouteId(tripRepository.findById(fromTime.getTripId()).get().getRoute_id());
		journey.setRouteName(routeRepository.findById(tripRepository.findById(fromTime.getTripId()).get().getRoute_id()).get().getName());
		try {
			journey.setDuration(calculateDuration(journey.getArrivalTime(), journey.getDepartureTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return journey;
	}

	private String calculateDuration(String arrivalTime, String departureTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(departureTime);
		Date date2 = format.parse(arrivalTime);
		
		Date date = new Date(date2.getTime() - date1.getTime());
		SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatter.format(date );
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

	@Override
	public ArrayList<List<Journey>> getRoundTrip(String fromCity, String toCity, String departureDate, String returnDate) {
		ArrayList<List<Journey>> response = new ArrayList<List<Journey>>();
		
		List<Journey> forwardJourney = getOneWayTrip(fromCity, toCity, departureDate);
		
		List<Journey> returnJourney = getOneWayTrip(toCity, fromCity, returnDate);
		
		response.add(forwardJourney);
		response.add(returnJourney);
		
		return response;
	}
}
