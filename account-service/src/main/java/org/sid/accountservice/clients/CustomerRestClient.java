package org.sid.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.sid.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customer/{customerId}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long customerId);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    List<Customer> findCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer=new Customer();
        customer.setCustomerId(id);
        customer.setFirstName("Not available");
        customer.setLastName("Not available");
        customer.setEmail("Not available");
        return customer;
    }
    default List<Customer> getAllCustomers(Exception exception) {
        return List.of();
    }
}
