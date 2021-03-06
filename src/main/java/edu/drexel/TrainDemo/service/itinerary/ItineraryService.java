package edu.drexel.TrainDemo.service.itinerary;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.RouteInfo;
import edu.drexel.TrainDemo.model.Itinerary.Segment;

@Service
public interface ItineraryService {

	List<Itinerary> getItineraries();

	Stop addStop(Stop stop);

	List<Route> getRouteInfo();

	List<RouteInfo> getTripInfo();

	Segment getItinerary(String fromStn, String toStn, Long tripId) throws ParseException;

	
	StopTime getStopTimeByTripIdandStnCode(StopTimeIdClass StopTimeIdClass);

	edu.drexel.TrainDemo.entities.itinerary.Itinerary saveItinerary(
			edu.drexel.TrainDemo.entities.itinerary.Itinerary itinerary);

}
