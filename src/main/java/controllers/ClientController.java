package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public ModelAndView viewUserIndex() {
		return new ModelAndView("client_index");
	}
	
	@GetMapping("/clients/create")
	public ModelAndView viewUserCreationForm() {
		return new ModelAndView("client_create");
	}
	
	@PostMapping("/clients/create")
	public ModelAndView createClient(@RequestParam("firstname") String firstname,
									 @RequestParam("lastname") String lastname,
									 @RequestParam("password") String password) {
		clientService.createClient(firstname, lastname, password);
		return new ModelAndView("redirect:/clients/list");
	}
	
    @GetMapping("/clients/list")
    public ModelAndView listClients() {
    	ModelAndView model = new ModelAndView("client_list");
    	model.addObject("clients", clientService.allClients());
    	return model;
    }
    
    @PostMapping("/clients/{id}/delete")
    public ModelAndView removeClient(@PathVariable("id") int id) {
    	clientService.deleteClient(id);
    	return new ModelAndView("redirect:/clients/list");
    }
    
}
