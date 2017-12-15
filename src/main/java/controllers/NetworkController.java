package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.NetworkService;

@Controller
public class NetworkController {

	@Autowired
	private NetworkService networkService;
	
	@GetMapping("/networks")
	public ModelAndView viewNetworksIndex() {
		return new ModelAndView("network_index");
	}
	
	@GetMapping("/networks/list")
	public ModelAndView listNetworks() {
		ModelAndView model = new ModelAndView("network_list");
		model.addObject("networks", networkService.list());
		return model;
	}
	
	@GetMapping("/networks/create")
	public ModelAndView viewCreationForm() {
		return new ModelAndView("network_create");
	}
	
	@PostMapping("/networks/create")
	public ModelAndView createNetwork(@RequestParam("network") String network,
									  @RequestParam("driver") String driver) {
		networkService.create(network, driver);
		return new ModelAndView("redirect:/networks/list");
	}
	
	@GetMapping("/networks/connect")
	public ModelAndView viewConnectionForm() {
		return new ModelAndView("network_connect");
	}
	
	@PostMapping("/networks/connect")
	public ModelAndView connectContainerToNetwork(@RequestParam("container") String container, 
												  @RequestParam("network") String network) {
		networkService.connect(network, container);
		return new ModelAndView("redirect:/networks/list");
	}
	
	@PostMapping("/networks/disconnect")
	public ModelAndView disconnectContainerToNetwork(@RequestParam("container") String container,
													 @RequestParam("network") String network) {
		networkService.disconnect(network, container);
		return new ModelAndView("redirect:/networks/list");
	}
	
	@PostMapping("/networks/{id}/delete")
	public ModelAndView removeNetwork(@PathVariable("id") String id) {
		networkService.remove(id);
		return new ModelAndView("redirect:/networks/list");
	}
}
