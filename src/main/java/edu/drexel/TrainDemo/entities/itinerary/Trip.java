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

    @ManyToOne
    private Route route;
    
    @ManyToOne
    private Calendar calender;

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

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Calendar getCalender() {
		return calender;
	}

	public void setCalender(Calendar calender) {
		this.calender = calender;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", headsign=" + headsign + ", direction=" + direction + ", route=" + route
				+ ", calender=" + calender + "]";
	}

}
