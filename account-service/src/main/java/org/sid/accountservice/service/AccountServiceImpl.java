package org.sid.accountservice.service;

import org.sid.accountservice.entities.Account;
import org.sid.accountservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account accountById(String accountId) {
        return accountRepository.findById(accountId).get();
    }

    @Override
    public List<Account> allAccounts() {
        return accountRepository.findAll();
    }
}
