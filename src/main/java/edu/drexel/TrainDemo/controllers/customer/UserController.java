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
import org.springframework.web.bind.annotation.ResponseBody;

import edu.drexel.TrainDemo.model.customer.Users;

@Controller
public class UserController {

	@RequestMapping("/admin/users")
	public String getUsers(Model model) {
		model.addAttribute("user", new Users());
		return "manageusers";

	}

	@RequestMapping("/admin/groups")
	public String getGroups(Model model) {
		return "managegroups";

	}

	@PostMapping("/admin/users/save")
	public String saveUser(@ModelAttribute("user") Users user, Model model) {
		System.out.println(user);
		model.addAttribute("user", user);
		return "manageusers";

	}

	@GetMapping("/user")
	@ResponseBody
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		System.out.println("hello" );
		return Collections.singletonMap("name", principal.getAttribute("name"));
	}
}
