package com.example.banqueacountservice.dto;

import com.example.banqueacountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class BankAccountRequestDto {


    private Double balance;
    private String currency;

    private AccountType type;
}
