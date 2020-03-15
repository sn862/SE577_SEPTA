package edu.drexel.TrainDemo.repositories.order;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.entities.order.Orders;


public interface OrderRepository extends CrudRepository<Orders, Long> {

}
