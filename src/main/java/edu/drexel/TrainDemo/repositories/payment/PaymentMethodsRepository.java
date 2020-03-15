package edu.drexel.TrainDemo.repositories.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.drexel.TrainDemo.entities.payment.PaymentMethod;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethod, String> {

}
