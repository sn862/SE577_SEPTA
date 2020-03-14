package edu.drexel.TrainDemo.model.Itinerary;

import java.util.List;

public class OneWayTrip {

	private List<Itinerary2> fromItinerary;

	public List<Itinerary2> getFromItinerary() {
		return fromItinerary;
	}

	public void setFromItinerary(List<Itinerary2> fromItinerary) {
		this.fromItinerary = fromItinerary;
	}

	@Override
	public String toString() {
		return "OneWayTrip [fromItinerary=" + fromItinerary + "]";
	}

	
	
}
