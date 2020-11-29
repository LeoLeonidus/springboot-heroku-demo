package net.verzoni.heroku;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private UserRepository repository;
	@Autowired
	public HomeController(UserRepository repository) {
	this.repository = repository;
	}
	@GetMapping("/")
	public String home(Model model) {
	List<User> users = repository.findAll();
	model.addAttribute("users", users);
	return "home";
	}
}
