package services;

import java.util.List;

import entities.Client;

public interface ClientService {

	public String test();
	public List<Client> allClients();
	public void createClient(String firstName, String lastName, String password);
	public void createClient(Client client);
	public void deleteClient(int id);
}
