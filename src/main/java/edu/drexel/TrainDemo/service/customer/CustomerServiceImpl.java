package edu.drexel.TrainDemo.service.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.customer.Address;
import edu.drexel.TrainDemo.entities.customer.Customer;
import edu.drexel.TrainDemo.entities.customer.passenger;
import edu.drexel.TrainDemo.model.customer.Passenger;
import edu.drexel.TrainDemo.repositories.customer.AddressRepository;
import edu.drexel.TrainDemo.repositories.customer.CustomerRepository;
import edu.drexel.TrainDemo.repositories.customer.PassengerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepo;
	private AddressRepository addressRepo;
	private PassengerRepository passengerRepo;

	public CustomerServiceImpl(CustomerRepository customerRepo, AddressRepository addressRepo,
			PassengerRepository passengerRepo) {
		super();
		this.customerRepo = customerRepo;
		this.addressRepo = addressRepo;
		this.passengerRepo = passengerRepo;
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

	@Override
	public Customer saveCustomer(Customer model) {
		Customer c = new Customer(model.getFirstName(), model.getLastName(), model.getAge(), model.getEmail(),
				model.getContactNumber());
		return customerRepo.save(c);
	}

	@Override
	public Customer saveCustomer(edu.drexel.TrainDemo.model.customer.Customer model) {
		Customer c = new Customer(model.getFirstName(), model.getLastName(), model.getAge(), model.getEmail(),
				model.getContactNumber());
		return customerRepo.save(c);
	}

	@Override
	public Address saveAddressDetails(Address address) {

		return addressRepo.save(address);
	}

	@Override
	public List<passenger> savePassengers(List<Passenger> passengerList, Long customerId) {

		List<passenger> listOfPassengers = new ArrayList();

		for (Passenger passenger : passengerList) {
			passenger passengerDetails = new passenger();
			passengerDetails.setCustomerId(customerId);
			passengerDetails.setfName(passenger.getfName());
			passengerDetails.setlName(passenger.getlName());
			passengerDetails.setAge(passenger.getAge());
			listOfPassengers.add(passengerRepo.save(passengerDetails));

		}

		return listOfPassengers;

	}

}
