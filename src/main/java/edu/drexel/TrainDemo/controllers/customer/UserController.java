package edu.drexel.TrainDemo.controllers.customer;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.model.customer.Users;
import edu.drexel.TrainDemo.model.user.User;

@Controller
@RequestMapping("/admin/*")
public class UserController {

	@RequestMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute("user", new Users());
		return "manageusers";
		
	}
	
	
	@RequestMapping("/groups")
	public String getGroups(Model model) {
		return "managegroups";
		
	}
	

	@PostMapping("/users/save")
	public String saveUser(@ModelAttribute("user") Users user, Model model) {
		System.out.println(user);
		model.addAttribute("user", user);
		return "manageusers";
		
	}
	
	 @GetMapping("/user")
	    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
	        return Collections.singletonMap("name", principal.getAttribute("name"));
	    }
}
