package edu.drexel.TrainDemo.controllers.customer;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class UserController {

	@RequestMapping("/users")
	public String getUsers(Model model) {
		return "manageusers";
		
	}
	
	
	@RequestMapping("/groups")
	public String getGroups(Model model) {
		return "managegroups";
		
	}
	
	 @GetMapping("/user")
	    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
	        return Collections.singletonMap("name", principal.getAttribute("name"));
	    }
}
