package edu.drexel.TrainDemo.model.Itinerary;

import java.util.List;

public class RoundTrip {

	private List<Itinerary2> fromItinerary;

	private List<Itinerary2> toItinerary;

	public List<Itinerary2> getFromItinerary() {
		return fromItinerary;
	}

	public void setFromItinerary(List<Itinerary2> fromItinerary) {
		this.fromItinerary = fromItinerary;
	}

	public List<Itinerary2> getToItinerary() {
		return toItinerary;
	}

	public void setToItinerary(List<Itinerary2> toItinerary) {
		this.toItinerary = toItinerary;
	}

	@Override
	public String toString() {
		return "RoundTrip [fromItinerary=" + fromItinerary + ", toItinerary=" + toItinerary + "]";
	}

}
