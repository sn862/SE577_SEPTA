package edu.drexel.TrainDemo.model.payment;

public class Payment {

	private String paymentType;
	private int cnum;
	private String cname;
	private String month;
	private int year;
	private int cvv;
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Payment [paymentType=" + paymentType + ", cnum=" + cnum + ", cname=" + cname + ", month=" + month
				+ ", year=" + year + ", cvv=" + cvv + ", price=" + price + "]";
	}

}
