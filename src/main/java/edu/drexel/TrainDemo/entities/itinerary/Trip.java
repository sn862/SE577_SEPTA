package edu.drexel.TrainDemo.entities.itinerary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trip {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String headsign;
    private RouteType direction;

    private Long route_id;
    
    private Long calendar_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeadsign() {
		return headsign;
	}

	public void setHeadsign(String headsign) {
		this.headsign = headsign;
	}

	public RouteType getDirection() {
		return direction;
	}

	public void setDirection(RouteType direction) {
		this.direction = direction;
	}

	public Long getRoute_id() {
		return route_id;
	}

	public void setRoute_id(Long route_id) {
		this.route_id = route_id;
	}

	public Long getCalendar_id() {
		return calendar_id;
	}

	public void setCalendar_id(Long calendar_id) {
		this.calendar_id = calendar_id;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", headsign=" + headsign + ", direction=" + direction + ", route_id=" + route_id
				+ ", calendar_id=" + calendar_id + "]";
	}

	
}
