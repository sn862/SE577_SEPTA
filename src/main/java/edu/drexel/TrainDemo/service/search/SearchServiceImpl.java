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

import edu.drexel.TrainDemo.Utils.Utils;
import edu.drexel.TrainDemo.entities.itinerary.Calendar;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;
import edu.drexel.TrainDemo.entities.itinerary.Trip;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary2;
import edu.drexel.TrainDemo.model.Itinerary.OneWayTrip;
import edu.drexel.TrainDemo.model.Itinerary.RoundTrip;
import edu.drexel.TrainDemo.model.Itinerary.Segment;
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
	public OneWayTrip getOneWayTrip(String fromCity, String toCity, String date) {
		OneWayTrip oneWayTrip = new OneWayTrip();
		
		oneWayTrip. setFromItinerary(getItineraries(fromCity, toCity, date));
		return oneWayTrip;
	}

	private List<Itinerary2> getItineraries(String fromCity, String toCity, String date) {
		List<Itinerary2> fromItineraries= new ArrayList<Itinerary2>();
		
		
		List<StopTime> fromStations = filterTripsBydate(fromCity, date);
		
		
		for (StopTime fromTime : fromStations) {
			Itinerary2 itinerary= new Itinerary2();
			List<Segment> segments = new ArrayList<Segment>();
			Optional<StopTime> toTime = stopTimeRepository.findById(new StopTimeIdClass(toCity, fromTime.getTripId()));
			if (toTime.isPresent() && (fromTime.getStopSequence() < toTime.get().getStopSequence())) {
				
				segments.add(constructJourney(fromTime, toTime));
				itinerary.setSegments(segments);
				fromItineraries.add(itinerary);
			} else {

			}		
			
		}
		
		
		
		
		return fromItineraries;
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

	private Segment constructJourney(StopTime fromTime, Optional<StopTime> toTime)  {
		Segment segment= new Segment();
		segment.setDepartureStation(fromTime);
		segment.setArrivalStation(toTime.get());
		try {
			segment.setDuration(Utils.calculateDuration(fromTime.getDeparture_time(),toTime.get().getArrival_time()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		segment.setTripId(fromTime.getTripId());
		List<String> trainClasses = new ArrayList<String>();
		trainClasses.add("Saver");
		trainClasses.add("Value");
		trainClasses.add("Flexible");
		trainClasses.add("Business");
		trainClasses.add("Premium");		
		List<Double> prices = new ArrayList<Double>();
		prices.add(60.0);
		prices.add(120.0);
		prices.add(180.0);
		prices.add(220.0);
		prices.add(290.0);		
		segment.setTrainClasses(trainClasses);
		segment.setPrices(prices);
		segment.setRoute(routeRepository.findById(tripRepository.findById(fromTime.getTripId()).get().getRoute_id()).get());		
		return segment;
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
	public RoundTrip getRoundTrip(String fromCity, String toCity, String departureDate, String returnDate) {
		RoundTrip roundTrip = new RoundTrip();
		roundTrip.setFromItinerary(getItineraries(fromCity, toCity, departureDate));
		roundTrip.setToItinerary(getItineraries(toCity, fromCity, returnDate));
		
		
		return roundTrip;
	}
}
