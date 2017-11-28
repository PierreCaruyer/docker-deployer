package controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Client;
import services.ClientService;

@RestController
@EnableAutoConfiguration
public class RestSampleController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClientService clientService;
    
    /*@RequestMapping(value="/books123", method=RequestMethod.GET)
    public List<Book> getBooks(){
    	return sampleService.getBooks();
    }
    
    @RequestMapping(value="/createClient", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String createClient(@RequestBody ClientDTO clientDTO) {
    	Client client = modelMapper.map(clientDTO, Client.class);
    	sampleService.createClient(client);
    	return "ok created";
    }*/
    
    /*@RequestMapping(value="/allClientsJson", method=RequestMethod.GET)
    public List<ClientDTO> allClientsJson() {
    	List<Client> clientList = sampleService.allClients();
    	return clientList.stream().map(c -> modelMapper.map(c, ClientDTO.class)).collect(Collectors.toList());
    }*/
    
    @RequestMapping(value="/createClient/{firstName}/{lastName}/{password}", method=RequestMethod.GET)
    public String createClient(
    		@PathVariable("firstName") String firstName,
    		@PathVariable("lastName") String lastName,
    		@PathVariable("password") String password) {
    	clientService.createClient(firstName, lastName, password);
    	return "ok created";
    }
    
    @RequestMapping(value="/allClients", method=RequestMethod.GET)
    public List<Client> allClients() {
    	return clientService.allClients();
    }
    
    /*@RequestMapping("/test1234")
    ModelAndView test1234() {
    	ModelAndView model = new ModelAndView("index");
    	return model;
    }
    @RequestMapping(value="/users/list", method=RequestMethod.GET)
    public ModelAndView testjstl() {
    	List<Client> clients = sampleService.allClients();
    	ModelAndView model = new ModelAndView("clients");
    	model.addObject("clients", clients);
    	return model;
    	//return "test";
    }*/
    
    /*@RequestMapping(value="/daotest", method=RequestMethod.GET)
    String daotest() {
        return sampleService.daotest();
    }*/
    
}
