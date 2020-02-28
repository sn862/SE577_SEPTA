package edu.drexel.TrainDemo.repositories.itinerary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.entities.itinerary.Route;

public interface RouteRepository extends CrudRepository<Route, Long> {
    List<Route> findByAgency_Id(long agencyId);
}