package dao;

import java.util.List;

import entities.Client;
import exception.ClientNotFoundException;

public interface ClientDAO {

	public List<Client> findClients();
	public Client getClientById(int id) throws ClientNotFoundException;
	public void addClient(Client c);
	public void deleteClient(int id);
	public void deleteClient(Client c);
}
