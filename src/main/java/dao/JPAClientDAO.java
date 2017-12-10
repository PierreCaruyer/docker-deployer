package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entities.Client;
import exception.ClientNotFoundException;

@Repository
public class JPAClientDAO implements ClientDAO {

	private static final String PERSISTENCE_UNIT_NAME = "mvc";
	private EntityManagerFactory emf;
	private EntityManager em;

	public JPAClientDAO() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

	public List<Client> findClients() {
		String sql = "SELECT c FROM Client c ";

		Query query = em.createQuery(sql);

		List<Client> clients = query.getResultList();

		return clients;
	}

	public Client getClientById(int id) throws ClientNotFoundException {
		String sql = "SELECT c FROM Client c WHERE c.id = :id";

		Query query = em.createQuery(sql);
		query.setParameter("id", id);

		Client client = (Client)query.getSingleResult();

		if(client == null) throw new ClientNotFoundException();
		
		return client;
	}

	public void addClient(Client c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	public void deleteClient(int id) {
		try {
			Client c = getClientById(id);
			deleteClient(c);
		} catch (ClientNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteClient(Client c) {
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
}
