package edu.drexel.TrainDemo.entities.itinerary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Itinerary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fromStation;
	private String toStation;
	private double price;
	private Long tripId;
	private Long orderId;
	private String depDate;
	private String depTime;
	private String arrDate;
	private String arrTime;

	public Itinerary(String fromStn, String toStn, Double price, Long tripId, Long orderId, String departureDate,
			String departureTime, String arrivalTime) {
		this.fromStation = fromStn;
		this.toStation = toStn;
		this.price = price;
		this.tripId = tripId;
		this.orderId = orderId;
		this.depDate = departureDate;
		this.depTime = departureTime;
		this.arrDate = departureDate;
		this.arrTime = arrivalTime;

	}

	public Itinerary() {

	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		price = price;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepDate() {
		return depDate;
	}

	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getArrDate() {
		return arrDate;
	}

	public void setArrDate(String arrDate) {
		this.arrDate = arrDate;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

}
