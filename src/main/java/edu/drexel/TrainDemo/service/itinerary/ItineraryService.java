package edu.drexel.TrainDemo.service.itinerary;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;
import edu.drexel.TrainDemo.model.Itinerary.Itinerary;
import edu.drexel.TrainDemo.model.Itinerary.RouteInfo;

@Service
public interface ItineraryService {

	List<Itinerary> getItineraries();

	Stop addStop(Stop stop);

	List<Route> getRouteInfo();

	List<RouteInfo> getTripInfo();

	StopTime getStopTimeByTripIdandStnCode(StopTimeIdClass StopTimeIdClass);

	edu.drexel.TrainDemo.entities.itinerary.Itinerary saveItinerary(
			edu.drexel.TrainDemo.entities.itinerary.Itinerary itinerary);

}
