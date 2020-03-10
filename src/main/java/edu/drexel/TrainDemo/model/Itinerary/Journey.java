package edu.drexel.TrainDemo.model.Itinerary;

import java.util.HashMap;
import java.util.Map;

public class Journey {

	private String fromStaionCode;
	private String fromStationName;
	private String toStationCode;
	private String toStationName;
	private String departureTime;
	private String arrivalTime;
	private String routeName;
	private Long routeId;
	private String duration;
	private String saverPrice;
	private String valuePrice;
	private String flexiblePrice;
	private String businessPrice;
	private String premiumPrice;
	private String tripType;
	private String tripId;
	
	
	
	
	public String getFromStaionCode() {
		return fromStaionCode;
	}
	public void setFromStaionCode(String fromStaionCode) {
		this.fromStaionCode = fromStaionCode;
	}
	public String getFromStationName() {
		return fromStationName;
	}
	public void setFromStationName(String fromStationName) {
		this.fromStationName = fromStationName;
	}
	public String getToStationCode() {
		return toStationCode;
	}
	public void setToStationCode(String toStationCode) {
		this.toStationCode = toStationCode;
	}
	public String getToStationName() {
		return toStationName;
	}
	public void setToStationName(String toStationName) {
		this.toStationName = toStationName;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	public String getSaverPrice() {
		return saverPrice;
	}
	public void setSaverPrice(String saverPrice) {
		this.saverPrice = saverPrice;
	}
	public String getValuePrice() {
		return valuePrice;
	}
	public void setValuePrice(String valuePrice) {
		this.valuePrice = valuePrice;
	}
	public String getFlexiblePrice() {
		return flexiblePrice;
	}
	public void setFlexiblePrice(String flexiblePrice) {
		this.flexiblePrice = flexiblePrice;
	}
	public String getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(String businessPrice) {
		this.businessPrice = businessPrice;
	}
	public String getPremiumPrice() {
		return premiumPrice;
	}
	public void setPremiumPrice(String premiumPrice) {
		this.premiumPrice = premiumPrice;
	}
	@Override
	public String toString() {
		return "Journey [fromStaionCode=" + fromStaionCode + ", fromStationName=" + fromStationName + ", toStationCode="
				+ toStationCode + ", toStationName=" + toStationName + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", TrainName=" + routeName + ", trainId=" + routeId + ", duration="
				+ duration + "]";
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getTripId() {
		return tripId;
	}
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	
	
}
