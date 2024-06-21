package com.service;

import java.util.List;
import java.util.OptionalDouble;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClientDao;
import com.model.Client;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    ClientDao dao;

    @Override
    public List<Client> getAllClients() {
        logger.info("Fetching all clients from the database");
        List<Client> clients = dao.getAllClients();
        logger.info("Found {} clients in the database", clients.size());
        return clients;
    }

    @Override
    public boolean addClient(Client client) {
        logger.info("Attempting to add client: {}", client);
        try {
            logger.debug("Calling DAO to add client: {}", client);
            dao.addClient(client);
            logger.info("Successfully added client: {}", client);
            return true;
        } catch (Exception e) {
            logger.error("Error while adding client: {}", client, e);
            return false;
        }
    }

    @Override
    public double getAverageAge() {
        logger.info("Calculating average age of clients");
        List<Client> clients = getAllClients();
        OptionalDouble averageAge = clients.stream()
                .mapToInt(Client::getAge)
                .average();
        double average = averageAge.orElse(0.0);
        logger.debug("Calculated average age: {}", average);
        return average;
    }

    @Override
    public double getStandardDeviationOfAge() {
        logger.info("Calculating standard deviation of age of clients");
        List<Client> clients = getAllClients();
        double mean = getAverageAge();
        double variance = clients.stream()
                .mapToDouble(client -> Math.pow(client.getAge() - mean, 2))
                .average()
                .orElse(0.0);
        double standardDeviation = Math.sqrt(variance);
        logger.debug("Calculated standard deviation of age: {}", standardDeviation);
        return standardDeviation;
    }
}
