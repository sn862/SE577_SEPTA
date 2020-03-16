package edu.drexel.TrainDemo.service.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.entities.customer.passenger;
import edu.drexel.TrainDemo.model.customer.Passenger;

@Service
public interface CustomerService {

	Customer getCustomerDetails();

	void updateCustomerDetails(Customer customer);

	void updateBillingDetails(Address address);

	Customer saveCustomer(Customer customer);

//	Long saveCustomer(Customer customer);

	Address saveAddressDetails(Address address);

	List<passenger> savePassengers(List<Passenger> passengerList, Long customerId);

	Customer saveCustomer(edu.drexel.TrainDemo.model.customer.Customer model);

}
