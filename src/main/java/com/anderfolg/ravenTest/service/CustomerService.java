package com.anderfolg.ravenTest.service;

import com.anderfolg.ravenTest.entities.Customer;
import com.anderfolg.ravenTest.entities.CustomerDTO;

import java.util.List;

public interface CustomerService {
    Customer createCustomer( CustomerDTO customerDTO);
    List<Customer> readAllCustomers();
    Customer readCustomerById(Long id);
    Customer updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);

}
