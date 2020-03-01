package edu.drexel.TrainDemo.repositories.itinerary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.drexel.TrainDemo.entities.itinerary.Stop;

public interface StopRepository extends JpaRepository<Stop, Long> {


	List<Stop> findByIdContainingIgnoreCase(String id);
	List<Stop> findByNameContainingIgnoreCase(String name);
	

}
