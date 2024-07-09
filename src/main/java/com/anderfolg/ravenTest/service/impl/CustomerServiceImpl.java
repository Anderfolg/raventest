package com.anderfolg.ravenTest.service.impl;

import com.anderfolg.ravenTest.entities.Customer;
import com.anderfolg.ravenTest.entities.CustomerDTO;
import com.anderfolg.ravenTest.repo.CustomerRepository;
import com.anderfolg.ravenTest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer createCustomer( CustomerDTO customerDTO ) {
        log.info("Creating new customer");
        Customer customer = Customer.builder()
                .fullName(customerDTO.fullName())
                .email(customerDTO.email())
                .phone(customerDTO.phone())
                .createdAt(LocalDateTime.now())
                .isActive(true)
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> readAllCustomers() {
        log.info("Retrieving all customers");
        return customerRepository.findAll();
    }

    @Override
    public Customer readCustomerById( Long id ) {
        log.info("Retrieving customer by id: {}", id);

        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public Customer updateCustomer( Long id, CustomerDTO customerDTO ) {
        log.info("Updating customer by id: {}", id);

        Customer customerToUpdate = readCustomerById(id);
        if ( customerDTO.fullName() != null )
            customerToUpdate.setFullName(customerDTO.fullName());
        if ( customerDTO.email() != null )
            customerToUpdate.setEmail(customerDTO.email());
        if ( customerDTO.phone() != null )
            customerToUpdate.setPhone(customerDTO.phone());
        customerToUpdate.setUpdatedAt(LocalDateTime.now());

        return customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteCustomer( Long id ) {
        log.info("Deleting customer by id: {}", id);

        Customer customerToDelete = readCustomerById(id);
        customerToDelete.setActive(false);
        customerRepository.save(customerToDelete);
    }
}
