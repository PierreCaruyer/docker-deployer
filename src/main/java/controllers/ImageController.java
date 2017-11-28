package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.DockerService;

@Controller
public class ImageController {
	
	@Autowired
	private DockerService dockerService; 
	
	@RequestMapping(value = "/images", method = RequestMethod.GET)
	public ModelAndView viewImagesIndex() {
		return new ModelAndView("image_index");
	}
	
	@RequestMapping(value = "/images/list", method = RequestMethod.GET)
	public ModelAndView listImages() {
		ModelAndView model = new ModelAndView("image_list");
		model.addObject("images", dockerService.listImages());
		return model;
	}
	
	@RequestMapping(value = "/images/pull", method = RequestMethod.GET)
	public ModelAndView viewPullForm() {
		return new ModelAndView("image_pull");
	}
	
	@RequestMapping(value = "/images/pull", method = RequestMethod.POST)
	public ModelAndView pullImage(@RequestParam("image") String image) {
		dockerService.pullImage(image);
		return new ModelAndView("redirect:/images/list");
	}
}