package org.sid.accountservice.service;

import org.sid.accountservice.entities.Account;

import java.util.List;

public interface AccountService {
    Account accountById(String accountId);
    List<Account> allAccounts();
}
