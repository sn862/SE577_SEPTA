package edu.drexel.TrainDemo.entities.itinerary;

import java.io.Serializable;

public class StopTimeIdClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stop_id;
	private long trip_id;
	
	public StopTimeIdClass() {
	}
	public StopTimeIdClass(String stop_id, long i) {
		super();
		this.stop_id = stop_id;
		this.trip_id = i;
	}
	
	
	public String getStop_id() {
		return stop_id;
	}


	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}


	


	public long getTrip_id() {
		return trip_id;
	}


	public void setTrip_id(long trip_id) {
		this.trip_id = trip_id;
	}
	
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stop_id == null) ? 0 : stop_id.hashCode());
		result = prime * result + (int) (trip_id ^ (trip_id >>> 32));
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
		if (stop_id == null) {
			if (other.stop_id != null)
				return false;
		} else if (!stop_id.equals(other.stop_id))
			return false;
		if (trip_id != other.trip_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StopTimeIdClass [stop_id=" + stop_id + ", trip_id=" + trip_id + "]";
	}
	
	
}
