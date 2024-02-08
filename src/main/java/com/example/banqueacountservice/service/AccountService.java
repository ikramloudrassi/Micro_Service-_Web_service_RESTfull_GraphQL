package com.example.banqueacountservice.service;

import com.example.banqueacountservice.dto.BankAccountReponseDto;
import com.example.banqueacountservice.dto.BankAccountRequestDto;
import com.example.banqueacountservice.entities.BankAccount;

public interface AccountService {
     BankAccountReponseDto AddAcount(BankAccountRequestDto BankAccountDto );

}
