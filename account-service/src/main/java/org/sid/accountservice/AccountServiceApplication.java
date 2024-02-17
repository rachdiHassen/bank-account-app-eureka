package org.sid.accountservice;

import org.sid.accountservice.clients.CustomerRestClient;
import org.sid.accountservice.entities.Account;
import org.sid.accountservice.enums.AccountType;
import org.sid.accountservice.model.Customer;
import org.sid.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountRepository accountRepository,
                            CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.findCustomers().forEach(customer -> {
                Account account1=Account.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random()*90000)
                        .createdAt(LocalDate.now())
                        .currency("USD")
                        .customerId(customer.getCustomerId())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .build();
                Account account2=Account.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random()*90000)
                        .createdAt(LocalDate.now())
                        .currency("USD")
                        .customerId(customer.getCustomerId())
                        .type(AccountType.SAVING_ACCOUNT)
                        .build();
                accountRepository.save(account1);
                accountRepository.save(account2);
            });



        };
    }
}
