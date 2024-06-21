package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Client;

public interface ClientJpa extends JpaRepository<Client, Integer> {
	
//	@Modifying
//	@Query("G")
//	List<Client> getAllClients();
	
//	Client findBy

}
