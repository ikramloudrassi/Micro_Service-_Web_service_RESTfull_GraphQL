package com.example.banqueacountservice.dto;

import com.example.banqueacountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class BankAccountReponseDto {
    private String id;
    private Date creationdate;
    private Double balance;
    private String currency;

    private AccountType type;
}
