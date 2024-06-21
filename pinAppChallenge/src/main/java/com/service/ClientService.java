package com.service;

import java.util.List;

import com.model.Client;

public interface ClientService {

	List<Client> getAllClients ();	
	boolean addClient (Client client);	
	public double getAverageAge();
	public double getStandardDeviationOfAge();
	
}
