package edu.drexel.TrainDemo.model.search;

import java.util.List;

import edu.drexel.TrainDemo.model.Itinerary.Journey;

public class Display {
	private SearchModel searchModel;
	private List<Journey> journyList;
	public SearchModel getSearchModel() {
		return searchModel;
	}
	public void setSearchModel(SearchModel searchModel) {
		this.searchModel = searchModel;
	}
	public List<Journey> getJournyList() {
		return journyList;
	}
	public void setJournyList(List<Journey> journyList) {
		this.journyList = journyList;
	}
	@Override
	public String toString() {
		return "Display [searchModel=" + searchModel + ", journyList=" + journyList + "]";
	}
	

}
