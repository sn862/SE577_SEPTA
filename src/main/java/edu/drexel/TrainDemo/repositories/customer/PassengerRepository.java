package edu.drexel.TrainDemo.repositories.customer;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.entities.customer.passenger;

public interface PassengerRepository extends CrudRepository<passenger, Long> {

}
