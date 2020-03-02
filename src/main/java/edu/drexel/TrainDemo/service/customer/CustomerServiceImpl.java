package edu.drexel.TrainDemo.service.customer;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.repositories.customer.AddressRepository;
import edu.drexel.TrainDemo.repositories.customer.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepo;
	private AddressRepository addressRepo;

	public CustomerServiceImpl(CustomerRepository customerRepo, AddressRepository addressRepo) {
		super();
		this.customerRepo = customerRepo;
		this.addressRepo = addressRepo;
	}

	@Override
	public Customer getCustomerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomerDetails(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public void updateBillingDetails(Address address) {
		addressRepo.save(address);
	}

}
