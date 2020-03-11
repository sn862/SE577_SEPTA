package edu.drexel.TrainDemo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.model.search.Display;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@PostMapping("/customer.html")
	public String getCustomerPage( @ModelAttribute("display") Display display) {
		System.out.println(display.getSearchModel());
		return "customer";
	}

}
