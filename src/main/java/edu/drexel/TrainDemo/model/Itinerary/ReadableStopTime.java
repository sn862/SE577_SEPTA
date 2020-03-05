package edu.drexel.TrainDemo.model.Itinerary;

public class ReadableStopTime {
	private String stopId;
	private String departureTime;
	
	public ReadableStopTime(String stopId, String departureTime) {
		super();
		this.stopId = stopId;
		this.departureTime = departureTime;
	}
	public String getStopId() {
		return stopId;
	}
	public void setStopId(String stopId) {
		this.stopId = stopId;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

}
