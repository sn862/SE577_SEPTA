package edu.drexel.TrainDemo.repositories.itinerary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;

public interface StopTimeRepository extends JpaRepository<StopTime, StopTimeIdClass> {


	List<StopTime> findByStopId(String stopId);

	List<StopTime> findByTripIdOrderByStopSequence(Long id);


}
