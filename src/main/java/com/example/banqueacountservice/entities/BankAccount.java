package com.example.banqueacountservice.entities;



import com.example.banqueacountservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private Date creationdate;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
