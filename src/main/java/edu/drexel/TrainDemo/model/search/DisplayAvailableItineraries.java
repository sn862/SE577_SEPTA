package edu.drexel.TrainDemo.model.search;

import edu.drexel.TrainDemo.model.Itinerary.OneWayTrip;

public class DisplayAvailableItineraries {
	private SearchModel searchModel;
	private OneWayTrip oneWayTrip;

	public SearchModel getSearchModel() {
		return searchModel;
	}

	public void setSearchModel(SearchModel searchModel) {
		this.searchModel = searchModel;
	}

	public OneWayTrip getOneWayTrip() {
		return oneWayTrip;
	}

	public void setOneWayTrip(OneWayTrip oneWayTrip) {
		this.oneWayTrip = oneWayTrip;
	}

	@Override
	public String toString() {
		return "DisplayAvailableItineraries [searchModel=" + searchModel + ", oneWayTrip=" + oneWayTrip + "]";
	}

}
