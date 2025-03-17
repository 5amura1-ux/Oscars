package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        try {
            List<Customer> customers = customerRepository.findAll();
            return customers.stream()
                    .filter(c -> c.getCustomerId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
