package edu.drexel.TrainDemo.repositories.customer;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.entities.customer.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
