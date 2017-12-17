package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"", "/", "/index", "/home"})
public class IndexController {

	@GetMapping
	public ModelAndView requestIndexOnGet() {
		return new ModelAndView("index");
	}
	
	@PostMapping
	public ModelAndView requestIndexOnPost() {
		return new ModelAndView("redirect:/home");
	}
}
