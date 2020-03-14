package edu.drexel.TrainDemo.model.search;

public class SearchModel {

	private String fromStn;
	private String toStn;
	private String departureDate;
	private String arrivalDate;
	private int numberOfTickets;
	private String tripType;
	private String tripId;
	private Double price;
	private String returnTripId;
	private String returnPrice;

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
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

	public String getReturnTripId() {
		return returnTripId;
	}

	public void setReturnTripId(String returnTripId) {
		this.returnTripId = returnTripId;
	}

	public String getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(String returnPrice) {
		this.returnPrice = returnPrice;
	}

	@Override
	public String toString() {
		return "SearchModel [fromStn=" + fromStn + ", toStn=" + toStn + ", departureDate=" + departureDate
				+ ", arrivalDate=" + arrivalDate + ", numberOfTickets=" + numberOfTickets + ", tripType=" + tripType
				+ ", tripId=" + tripId + ", price=" + price + ", returnTripId=" + returnTripId + ", returnPrice="
				+ returnPrice + "]";
	}

}
