package edu.drexel.TrainDemo.model.Itinerary;

public class Journey {

	private String fromStaionCode;
	private String fromStationName;
	private String toStationCode;
	private String toStationName;
	private String departureTime;
	private String arrivalTime;
	private String TrainName;
	private Long trainId;
	private String duration;
	
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
	public String getTrainName() {
		return TrainName;
	}
	public void setTrainName(String trainName) {
		TrainName = trainName;
	}
	public Long getTrainId() {
		return trainId;
	}
	public void setTrainId(Long long1) {
		this.trainId = long1;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Journey [fromStaionCode=" + fromStaionCode + ", fromStationName=" + fromStationName + ", toStationCode="
				+ toStationCode + ", toStationName=" + toStationName + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", TrainName=" + TrainName + ", trainId=" + trainId + ", duration="
				+ duration + "]";
	}
	
	
}
