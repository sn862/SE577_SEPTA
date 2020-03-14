package edu.drexel.TrainDemo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.model.customer.Customer;

@Controller
public class AdminHomeController {

	@RequestMapping("/admin")
	public String getAdminHomePage(Model model) {
		model.addAttribute("customer", new Customer());
		return "manageCustomers";
		
	}
}
