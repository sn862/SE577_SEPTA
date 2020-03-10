package edu.drexel.TrainDemo.model.search;

public class FowardForm {
	private String fromStn;
	private String toStn;
	private String price;
	private String triptype;
	private String departureDate;
	private String arrivalDate;
	private String numberOfTickets;
	private String tripId;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTriptype() {
		return triptype;
	}

	public void setTriptype(String triptype) {
		this.triptype = triptype;
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

	public String getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(String numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
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

	@Override
	public String toString() {
		return "FowardForm [fromStn=" + fromStn + ", toStn=" + toStn + ", price=" + price + ", triptype=" + triptype
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", numberOfTickets="
				+ numberOfTickets + ", tripId=" + tripId + "]";
	}

	
}
