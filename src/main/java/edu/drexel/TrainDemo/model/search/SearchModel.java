package edu.drexel.TrainDemo.model.search;

import java.util.Date;

public class SearchModel {

	private String fromStn;
	private String toStn;
	private String departureDate;
	private String arrivalDate;
	private int numberOfTickets;
	private String tripType;
	
	private String tripId;
	private String price;
	
	
	public String getTripId() {
		return tripId;
	}
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFromStn() {
		return fromStn;
	}
	public void setFromStn(String fromStn) {
		this.fromStn = fromStn;
	}
	public String getToStn() {
		return toStn;
	}
	public void setToStn(String toStn) {
		this.toStn = toStn;
	}
	
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	
	
	
}
