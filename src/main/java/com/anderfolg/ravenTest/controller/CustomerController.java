package com.anderfolg.ravenTest.controller;

import com.anderfolg.ravenTest.entities.CustomerDTO;
import com.anderfolg.ravenTest.entities.CustomerResponseDTO;
import com.anderfolg.ravenTest.service.CustomerMapper;
import com.anderfolg.ravenTest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController implements CustomerControllerSpec{
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    @Override
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer( CustomerDTO customerDTO ) {
        return ResponseEntity.ok(customerMapper.toResponseDTO(customerService.createCustomer(customerDTO)));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> readAllCustomers() {
        return ResponseEntity.ok(customerMapper.toResponseDTOList(customerService.readAllCustomers()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> readCustomerById( Long id ) {
        return ResponseEntity.ok(customerMapper.toResponseDTO(customerService.readCustomerById(id)));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer( Long id, CustomerDTO customerDTO ) {
        return ResponseEntity.ok(customerMapper.toResponseDTO(customerService.updateCustomer(id, customerDTO)));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer( Long id ) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
