package services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.geronimo.mail.util.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientDAO;
import entities.Client;

@Service
public class CientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDAO clientDAO;
	
	public String test() {
		return "c'est la java!";
	}
    
    public List<Client> allClients() {
    	return clientDAO.findClients();
    }
    
    public void createClient(String firstName, String lastName, String password) {	
    	MessageDigest digest;
    	String sha256hex = "";
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(
	    	password.getBytes(StandardCharsets.UTF_8));
	    	sha256hex = new String(Hex.encode(hash));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	
    	Client c = new Client();
    	c.setFirstName(firstName);
    	c.setLastName(lastName);
    	c.setPassword(sha256hex);
    	clientDAO.addClient(c);
    }
	
    public void createClient(Client client) {
    	clientDAO.addClient(client);
    }
    
    public void deleteClient(int id) {
    	clientDAO.deleteClient(id);
    }
}
