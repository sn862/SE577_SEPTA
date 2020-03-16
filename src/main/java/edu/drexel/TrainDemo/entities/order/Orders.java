package edu.drexel.TrainDemo.entities.order;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private Long customerId;
	private Long paymentId;
	private Date orderDate;
	private int quantity;
	private String status;
	private Double price;
	private Double returnPrice;

	public Orders() {

	}

	public Orders(Long customerId, Long paymentId, int numberOfTickets, Double price, Double returnPrice) {
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.quantity = numberOfTickets;
		this.price = price;
		this.status = "success";
		this.orderDate = new Date();
		if (returnPrice != null) {
			this.returnPrice = returnPrice;
		}

	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

}
