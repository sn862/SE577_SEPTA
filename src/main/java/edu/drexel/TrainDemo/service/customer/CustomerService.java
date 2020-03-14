package edu.drexel.TrainDemo.service.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;

@Service
public interface CustomerService {

	Customer getCustomerDetails();

	void updateCustomerDetails(Customer customer);

	void updateBillingDetails(Address address);

	Customer saveCustomer(edu.drexel.TrainDemo.model.customer.Customer model);

}
