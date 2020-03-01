package edu.drexel.TrainDemo.service.address;

import edu.drexel.TrainDemo.entities.checkout.Address;
import edu.drexel.TrainDemo.repositories.checkout.AddressRepository;

public class addressServiceImpl {

	private AddressRepository billingDetails;

	Address getAddressDetails() {

		return (Address) billingDetails.findAll();

	}

}
