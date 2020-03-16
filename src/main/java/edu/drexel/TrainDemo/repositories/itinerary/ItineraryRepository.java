package edu.drexel.TrainDemo.repositories.itinerary;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.drexel.TrainDemo.entities.itinerary.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

}
