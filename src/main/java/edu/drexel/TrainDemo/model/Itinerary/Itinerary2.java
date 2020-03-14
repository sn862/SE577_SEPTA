package edu.drexel.TrainDemo.model.Itinerary;

import java.util.Arrays;
import java.util.List;

public class Itinerary2 {

	private List<Segment> segments;

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	@Override
	public String toString() {
		return "Itinerary2 [segments=" + segments + "]";
	}

	
	
}
