package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ImageService;

@Controller
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping("/images")
	public ModelAndView viewImagesIndex() {
		return new ModelAndView("image_index");
	}
	
	@GetMapping("/images/list")
	public ModelAndView listImages() {
		ModelAndView model = new ModelAndView("image_list");
		model.addObject("images", imageService.list());
		return model;
	}
	
	@GetMapping("/images/pull")
	public ModelAndView viewPullForm() {
		return new ModelAndView("image_pull");
	}
	
	@PostMapping("/images/pull")
	public ModelAndView pullImage(@RequestParam("image") String image) {
		imageService.pull(image);
		return new ModelAndView("redirect:/images/list");
	}
	
	@PostMapping("/images/{id}/delete")
	public ModelAndView deleteImage(@PathVariable("id") String image) {
		imageService.remove(image);
		return new ModelAndView("redirect:/images/list");
	}
}
