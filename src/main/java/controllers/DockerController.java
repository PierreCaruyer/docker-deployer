package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.DockerService;

@Controller
public class DockerController {
	
	@Autowired
	private DockerService dockerService;

	@RequestMapping("/containers")
	public ModelAndView viewContainersIndex() {
		return new ModelAndView("container_index");
	}
	
	@RequestMapping(value="/containers/create", method=RequestMethod.GET)
	public ModelAndView viewContainerCreationForm() {
		return new ModelAndView("container_create");
	}
	
	@RequestMapping(value="/containers/create", method=RequestMethod.POST)
	public ModelAndView createContainer(@RequestParam("image") String image) {
		dockerService.create(image, "host");
		return new ModelAndView("redirect:/containers/list");
	}
	
	@RequestMapping(value="/containers/list", method=RequestMethod.GET)
	public ModelAndView listContainers() {
		ModelAndView model = new ModelAndView("container_list");
		model.addObject("containers", dockerService.listContainers());
		return model;
	}
	
	@RequestMapping(value="/containers/{id}/delete", method=RequestMethod.POST)
	public ModelAndView removeContainer(@PathVariable("id") String id) {
		dockerService.remove(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@RequestMapping(value="/containers/{id}/start", method=RequestMethod.POST)
	public ModelAndView startContainer(@PathVariable("id") String id) {
		dockerService.start(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@RequestMapping(value="/containers/{id}/stop", method=RequestMethod.POST)
	public ModelAndView stopContainer(@PathVariable("id") String id) {
		dockerService.stop(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@RequestMapping(value="/containers/{id}/pause", method=RequestMethod.POST)
	public ModelAndView pauseContainer(@PathVariable("id") String id) {
		dockerService.pause(id);
		return new ModelAndView("redirect:/containers/list");
	}
	
	@RequestMapping(value="/containers/{id}/resume", method=RequestMethod.POST)
	public ModelAndView resumeContainer(@PathVariable("id") String id) {
		dockerService.unpause(id);
		return new ModelAndView("redirect:/containers/list");
	}
}
