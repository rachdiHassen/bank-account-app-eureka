package org.sid.customerservice.service;

import org.sid.customerservice.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer CustomerById(Long customerId);
    List<Customer> allCustomer();
}
