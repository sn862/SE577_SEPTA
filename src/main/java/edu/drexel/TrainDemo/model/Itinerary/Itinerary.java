package edu.drexel.TrainDemo.model.Itinerary;

import java.util.Optional;

import edu.drexel.TrainDemo.entities.itinerary.Agency;
import edu.drexel.TrainDemo.entities.itinerary.Route;

public class Itinerary {

	private Optional<Agency> agency;
	private Optional<Route> route;

	public Optional<Route> getRoute() {
		return route;
	}

	public void setRoute(Optional<Route> optional) {
		this.route = optional;
	}

	public Optional<Agency> getAgency() {
		return agency;
	}

	public void setAgency(Optional<Agency> optional) {
		this.agency = optional;
	}
	
	
}
