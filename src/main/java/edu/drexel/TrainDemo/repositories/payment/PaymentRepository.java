package edu.drexel.TrainDemo.repositories.payment;

import org.springframework.data.repository.CrudRepository;

import edu.drexel.TrainDemo.entities.payment.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
