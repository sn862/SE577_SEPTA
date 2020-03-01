package edu.drexel.TrainDemo.entities.itinerary;

import java.io.Serializable;

public class StopTimeIdClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stopId;
	private long tripId;
	
	public StopTimeIdClass() {
		// TODO Auto-generated constructor stub
	}
	public StopTimeIdClass(String stopId, long tripId) {
		super();
		this.stopId = stopId;
		this.tripId = tripId;
	}
	public String getStopId() {
		return stopId;
	}
	public void setStopId(String stopId) {
		this.stopId = stopId;
	}
	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stopId == null) ? 0 : stopId.hashCode());
		result = prime * result + (int) (tripId ^ (tripId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StopTimeIdClass other = (StopTimeIdClass) obj;
		if (stopId == null) {
			if (other.stopId != null)
				return false;
		} else if (!stopId.equals(other.stopId))
			return false;
		if (tripId != other.tripId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StopTimeIdClass [stopId=" + stopId + ", tripId=" + tripId + "]";
	}
	
	
	
	
}
