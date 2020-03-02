package edu.drexel.TrainDemo.repositories.customer;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.entities.customer.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
