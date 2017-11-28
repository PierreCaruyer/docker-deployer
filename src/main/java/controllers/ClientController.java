package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public ModelAndView displayUserIndex() {
		return new ModelAndView("client_index");
	}
	
	@RequestMapping(value="/clients/create", method=RequestMethod.GET)
	public ModelAndView presentUserCreationForm() {
		return new ModelAndView("client_create");
	}
	
	/**
	 * POST
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/clients/create", method=RequestMethod.POST)
	public ModelAndView doUserCreation(@RequestParam("firstname") String firstname,
									   @RequestParam("lastname") String lastname,
									   @RequestParam("password") String password) {
		clientService.createClient(firstname, lastname, password);
		return new ModelAndView("redirect:/clients/list");
	}
	
	/**
	 * GET
	 * @return
	 */
    @RequestMapping(value="/clients/list", method=RequestMethod.GET)
    public ModelAndView listClients() {
    	ModelAndView model = new ModelAndView("client_list");
    	model.addObject("clients", clientService.allClients());
    	return model;
    }
    
    
    /**
     * DELETE
     * @param id
     * @return
     */
    @RequestMapping(value="/clients/{id}/delete", method=RequestMethod.POST)
    public ModelAndView deleteClient(@PathVariable("id") int id) {
    	clientService.deleteClient(id);
    	return new ModelAndView("redirect:/clients/list");
    }
    
}
