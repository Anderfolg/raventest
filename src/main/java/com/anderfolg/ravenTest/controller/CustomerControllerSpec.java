package com.anderfolg.ravenTest.controller;

import com.anderfolg.ravenTest.entities.CustomerDTO;
import com.anderfolg.ravenTest.entities.CustomerResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Customer", description = "Customer management")
public interface CustomerControllerSpec {
    @Operation(
            summary = "Create customer",
            description = "Create customer",
            tags = {"Customer"},
            responses = {@ApiResponse(responseCode = "201", description = "Customer created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponseDTO.class)))})
    ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerDTO customerDTO);

    @Operation(summary = "Retrieve All Customers",
            description = "Retrieves a list of all customers.",
            tags = {"Customer", "getAll"},
            responses = {@ApiResponse(responseCode = "200", description = "List of customers", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponseDTO.class)))})
    ResponseEntity<List<CustomerResponseDTO>> readAllCustomers();

    @Operation(summary = "Retrieve a Customer by ID",
            description = "Retrieves a customer by its unique identifier. The response includes the customer details (id, name, etc.).",
            tags = {"Customer", "get"},
            responses = {@ApiResponse(responseCode = "200", description = "Customer retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponseDTO.class))),
                    @ApiResponse(responseCode = "404" , description = "Customer not found")})
    ResponseEntity<CustomerResponseDTO> readCustomerById(@PathVariable Long id);

    @Operation(summary = "Update a Customer",
            description = "Updates an existing customer with the provided details (optional body).",
            tags = {"Customer", "update"},
            responses = {@ApiResponse(responseCode = "200", description = "Customer updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponseDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request (e.g., invalid data)"),
                    @ApiResponse(responseCode = "404", description = "Customer not found")})
    ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO);

    @Operation(summary = "Delete a Customer",
            description = "Deletes an existing customer.",
            tags = {"Customer", "delete"},
            responses = {@ApiResponse(responseCode = "200", description = "Customer deleted", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Customer not found")})
    ResponseEntity<Void> deleteCustomer(@PathVariable Long id);
}
