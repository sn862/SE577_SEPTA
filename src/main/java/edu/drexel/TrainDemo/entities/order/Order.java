package edu.drexel.TrainDemo.entities.order;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	private Long id;
	private Long customerId;
	private Long paymentId;
	private int ticketPrice;
	private Long iternaryId;

}
