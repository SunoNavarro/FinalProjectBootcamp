package atm.mg.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeCtl {
	
	@GetMapping({"/home","/welcome","/"})
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping({"/about"})
	public String about() {
		return "aboutus";
	}
	
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactUs";
	}
	

}
