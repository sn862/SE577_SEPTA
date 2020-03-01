package edu.drexel.TrainDemo.repositories.itinerary;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.drexel.TrainDemo.entities.itinerary.Calendar;

public interface CalenderRepository extends JpaRepository<Calendar, Long>{

}
