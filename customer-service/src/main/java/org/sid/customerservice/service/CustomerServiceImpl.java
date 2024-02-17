package org.sid.customerservice.service;

import org.sid.customerservice.entities.Customer;

import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer CustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }
}
