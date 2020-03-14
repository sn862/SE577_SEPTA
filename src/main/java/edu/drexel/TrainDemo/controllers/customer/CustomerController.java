package edu.drexel.TrainDemo.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.drexel.TrainDemo.model.customer.Customer;
import edu.drexel.TrainDemo.model.search.Display;
import edu.drexel.TrainDemo.service.customer.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer.html")
	public String getCustomerPage( @ModelAttribute("display") Display display) {
		System.out.println(display.getSearchModel());
		return "customer";
	}
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer model, Model model2) {
	    customerService.saveCustomer(model);
		return "manageCustomers";
	}

}
