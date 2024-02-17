package org.sid.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.accountservice.enums.AccountType;
import org.sid.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
