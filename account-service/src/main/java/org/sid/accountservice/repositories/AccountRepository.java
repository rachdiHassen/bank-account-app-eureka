package org.sid.accountservice.repositories;

import org.sid.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account,String> {
}
