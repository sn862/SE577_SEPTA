package edu.drexel.TrainDemo.entities.itinerary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.postgresql.util.PGInterval;

@Entity
@IdClass(StopTimeIdClass.class)
public class StopTime {

	@Id
	@Column(name="stop_id")
	private String stop_id;
	@Id
	@Column(name="trip_id")
	private Long trip_id;
	private int stop_sequence;
	
	  private String departure_time; private String arrival_time;
	 
	private int pickup_type;
	private int dropoff_type;
	
	public String getStop_id() {
		return stop_id;
	}
	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}
	
	public Long getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}

	
	public int getStop_sequence() {
		return stop_sequence;
	}
	public void setStop_sequence(int stop_sequence) {
		this.stop_sequence = stop_sequence;
	}

	
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public int getPickup_type() {
		return pickup_type;
	}
	public void setPickup_type(int pickup_type) {
		this.pickup_type = pickup_type;
	}
	public int getDropoff_type() {
		return dropoff_type;
	}
	public void setDropoff_type(int dropoff_type) {
		this.dropoff_type = dropoff_type;
	}
	@Override
	public String toString() {
		return "StopTime [stop_id=" + stop_id + ", trip_id=" + trip_id + ", stop_sequence=" + stop_sequence
				+ ", departure_time=" + departure_time + ", arrival_time=" + arrival_time + ", pickup_type="
				+ pickup_type + ", dropoff_type=" + dropoff_type + "]";
	}
		
}
