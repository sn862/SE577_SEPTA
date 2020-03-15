package edu.drexel.TrainDemo.entities.payment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentMethod {

	@Id
	private String paymentTypeCode;
	private boolean isActive;
	private String PaymentName;
	
	
	public PaymentMethod() {
		
	}
	public PaymentMethod(String paymentTypeCode, boolean isActive, String paymentName) {
		super();
		this.paymentTypeCode = paymentTypeCode;
		this.isActive = isActive;
		PaymentName = paymentName;
	}
	
	
	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}
	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPaymentName() {
		return PaymentName;
	}
	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
	}
	
}
