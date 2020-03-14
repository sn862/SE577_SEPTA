package edu.drexel.TrainDemo.model.Itinerary;

import java.util.List;

import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;

public class Segment {

	private StopTime departureStation;
	private StopTime arrivalStation;
	private Route route;
	private String duration;
	private List<String> trainClasses;
	private List<Double> prices;
	private Long tripId;
	
	
	
	public StopTime getDepartureStation() {
		return departureStation;
	}
	public void setDepartureStation(StopTime departureStation) {
		this.departureStation = departureStation;
	}
	public StopTime getArrivalStation() {
		return arrivalStation;
	}
	public void setArrivalStation(StopTime arrivalStation) {
		this.arrivalStation = arrivalStation;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<String> getTrainClasses() {
		return trainClasses;
	}
	public void setTrainClasses(List<String> trainClasses) {
		this.trainClasses = trainClasses;
	}
	public List<Double> getPrices() {
		return prices;
	}
	public void setPrices(List<Double> prices) {
		this.prices = prices;
	}
	
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	@Override
	public String toString() {
		return "Segment [departureStation=" + departureStation + ", arrivalStation=" + arrivalStation + ", route="
				+ route + ", duration=" + duration + ", trainClasses=" + trainClasses + ", prices=" + prices
				+ ", tripId=" + tripId + "]";
	}

	
}
