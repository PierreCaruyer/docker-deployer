package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ContainerService;

@Controller
public class ContainerController {
	
	@Autowired
	private ContainerService containerService;

	@GetMapping("/containers")
	public ModelAndView viewContainersIndex() {
		return new ModelAndView("container_index");
	}
	
	@GetMapping(value="/containers/create")
	public ModelAndView viewContainerCreationForm() {
		return new ModelAndView("container_create");
	}
	
	@PostMapping(value="/containers/create")
	public ModelAndView createContainer(@RequestParam("image") String image) {
		containerService.create(image, "host");
		return new ModelAndView("redirect:/containers/list");
	}
	
	@GetMapping(value="/containers/list")
	public ModelAndView listContainers() {
		ModelAndView model = new ModelAndView("container_list");
		model.addObject("containers", containerService.listContainers());
		return model;
	}
	
	@PostMapping(value="/containers/{id}/delete")
	public ModelAndView removeContainer(@PathVariable("id") String id) {
		containerService.remove(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@PostMapping(value="/containers/{id}/start")
	public ModelAndView startContainer(@PathVariable("id") String id) {
		containerService.start(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@PostMapping(value="/containers/{id}/stop")
	public ModelAndView stopContainer(@PathVariable("id") String id) {
		containerService.stop(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@PostMapping("/containers/{id}/pause")
	public ModelAndView pauseContainer(@PathVariable("id") String id) {
		containerService.pause(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@PostMapping("/containers/{id}/resume")
	public ModelAndView resumeContainer(@PathVariable("id") String id) {
		containerService.unpause(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@PostMapping("/containers/{id}/commit")
	public ModelAndView commitContainer(@PathVariable("id") String id) {
		containerService.commit(id);
		return new ModelAndView("redirect:/containers/list");
	}
}
