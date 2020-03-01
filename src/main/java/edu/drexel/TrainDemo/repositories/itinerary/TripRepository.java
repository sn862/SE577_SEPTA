package edu.drexel.TrainDemo.repositories.itinerary;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.drexel.TrainDemo.entities.itinerary.Trip;

public interface TripRepository extends JpaRepository<Trip, Long>{

}
