package org.sid.customerservice.web;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public Customer customerById(@PathVariable Long customerId){
        return customerService.CustomerById(customerId);
    }
    @GetMapping("/customers")
    public List<Customer> allCustomer(){
        return customerService.allCustomer();
    }
}
