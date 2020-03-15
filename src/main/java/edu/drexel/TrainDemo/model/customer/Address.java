package edu.drexel.TrainDemo.model.customer;

public class Address {

	private String strtAddressLine1;
	private String strrAddressLine2;
	private String city;
	private String state;
	private int zipcode;
	private String country;

	public String getStrtAddressLine1() {
		return strtAddressLine1;
	}

	public void setStrtAddressLine1(String strtAddressLine1) {
		this.strtAddressLine1 = strtAddressLine1;
	}

	public String getStrrAddressLine2() {
		return strrAddressLine2;
	}

	public void setStrrAddressLine2(String strrAddressLine2) {
		this.strrAddressLine2 = strrAddressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [strtAddressLine1=" + strtAddressLine1 + ", strrAddressLine2=" + strrAddressLine2 + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + "]";
	}

}
