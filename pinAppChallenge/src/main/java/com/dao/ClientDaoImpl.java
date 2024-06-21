package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Autowired
	ClientJpa clients;
	
	@Override
	public List<Client> getAllClients() {
		return clients.findAll();
	}

	@Override
	public void addClient(Client client) {
		clients.save(client);	
	}

	@Override
	public Client getClient(int clientId) {
		Optional<Client> clientOpt = clients.findById(clientId);
		return clientOpt.orElse(null);
	}
}
