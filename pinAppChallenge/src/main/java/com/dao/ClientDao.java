package com.dao;

import java.util.List;

import com.model.Client;

public interface ClientDao {

	List<Client> getAllClients ();
	
	void addClient (Client client);

	public Client getClient(int clientId);
	
	
	//TODO void kpiClients(); 
	
}
