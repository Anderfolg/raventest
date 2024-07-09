package com.anderfolg.ravenTest.service;

import com.anderfolg.ravenTest.entities.Customer;
import com.anderfolg.ravenTest.entities.CustomerResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerResponseDTO toResponseDTO( Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
    public List<CustomerResponseDTO> toResponseDTOList( List<Customer> customers) {
        return customers.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
}
