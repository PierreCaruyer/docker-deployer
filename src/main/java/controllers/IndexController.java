package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"", "/", "/index", "/home"})
public class IndexController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView requestIndexOnGet() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView requestIndexOnPost() {
		return new ModelAndView("redirect:/home");
	}
}
