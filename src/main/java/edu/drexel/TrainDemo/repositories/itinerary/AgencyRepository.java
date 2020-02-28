package edu.drexel.TrainDemo.repositories.itinerary;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.entities.itinerary.Agency;

public interface AgencyRepository extends CrudRepository<Agency, Long> { 
	
}
