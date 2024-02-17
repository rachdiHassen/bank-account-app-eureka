package org.sid.accountservice.web;

import org.sid.accountservice.clients.CustomerRestClient;
import org.sid.accountservice.entities.Account;
import org.sid.accountservice.model.Customer;
import org.sid.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRestClient customerRestClient;
    @GetMapping("/account/{accountId}")
    public Account accountById (@PathVariable String accountId){
        Account account = accountService.accountById(accountId);
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;

    }
    @GetMapping("/accounts")
    public List<Account> allAccounts(){

        List<Account> accounts = accountService.allAccounts();
        accounts.forEach(account -> {
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        });
        return accounts;
    }
}
