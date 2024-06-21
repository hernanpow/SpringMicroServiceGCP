package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.model.Client;
import com.service.ClientService;

@Tag(name = "Clients resource", description = "Operations related to client management")
@RestController
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService service;

    @Operation(
        summary = "Get all existing clients",
        description = "Fetch a list of all clients in the system",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successfully retrieved list of clients",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Client.class)
                )
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping(value = "/getAllClients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClients() {
        logger.info("Fetching all clients");
        List<Client> clients = service.getAllClients();
        logger.info("Found {} clients", clients.size());
        return ResponseEntity.ok(clients);
    }

    @Operation(
        summary = "Add a new client",
        description = "Add a new client to the system",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Client object that needs to be added",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Client.class),
                examples = @ExampleObject(
                    name = "Example client",
                    value = "{\"name\": \"John Doe\", \"age\": 30, \"email\": \"john.doe@example.com\"}"
                )
            ),
            required = true
        ),
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Client added successfully",
                content = @Content(mediaType = "text/plain", examples = @ExampleObject("Client added successfully"))
            ),
            @ApiResponse(responseCode = "409", description = "Failed to add client due to a conflict"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PostMapping(value = "/addClient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        logger.info("Received request to add client: {}", client);
        try {
            boolean isAdded = service.addClient(client);
            if (isAdded) {
                logger.info("Successfully added client");
                return ResponseEntity.status(HttpStatus.CREATED).body("Client added successfully");
            } else {
                logger.warn("Failed to add client");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Failed to add client");
            }
        } catch (Exception e) {
            logger.error("Error adding client: {}", client, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding client");
        }
    }

    @Operation(
        summary = "Calculate the KPI for all clients",
        description = "Calculate the average age and standard deviation of age for all clients",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successfully calculated KPI",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                        type = "string",
                        example = "{\"averageAge\": 35.5, \"standardDeviationAge\": 4.2}"
                    )
                )
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping(value = "/kpiClients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getKPIdeClientes() {
        double averageAge = service.getAverageAge();
        double standardDeviationAge = service.getStandardDeviationOfAge();
        logger.info("Calculating KPI: Average Age = {}, Standard Deviation of Age = {}", averageAge, standardDeviationAge);
        String kpiResponse = String.format("Average Age: %.2f, Standard Deviation of Age: %.2f", averageAge, standardDeviationAge);
        return ResponseEntity.ok(kpiResponse);
    }
}
