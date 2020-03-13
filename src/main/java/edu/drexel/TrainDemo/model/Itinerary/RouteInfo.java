package edu.drexel.TrainDemo.model.Itinerary;

import java.util.List;

public class RouteInfo {

	private long routeId;
	private String routeName;
	private List<ReadableStopTime> readableStopTime;
	
	
	public RouteInfo(long routeId, String routeName, List<ReadableStopTime> readableStopTime) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.readableStopTime = readableStopTime;
	}
	public long getRouteId() {
		return routeId;
	}
	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public List<ReadableStopTime> getReadableStopTime() {
		return readableStopTime;
	}
	public void setReadableStopTime(List<ReadableStopTime> readableStopTime) {
		this.readableStopTime = readableStopTime;
	}
	@Override
	public String toString() {
		return "RouteInfo [routeId=" + routeId + ", routeName=" + routeName + ", readableStopTime=" + readableStopTime
				+ "]";
	}
	
	
}
