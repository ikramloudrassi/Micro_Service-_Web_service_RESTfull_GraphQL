package com.example.banqueacountservice.service;

import com.example.banqueacountservice.dto.BankAccountReponseDto;
import com.example.banqueacountservice.dto.BankAccountRequestDto;
import com.example.banqueacountservice.entities.BankAccount;
import com.example.banqueacountservice.mappers.AccountMapper;
import com.example.banqueacountservice.repos.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountReponseDto AddAcount(BankAccountRequestDto BankAccountDto) {

        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .creationdate(new Date())
                .balance(BankAccountDto.getBalance())
                .type(BankAccountDto.getType())
                .currency(BankAccountDto.getCurrency())
                .build();

    BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountReponseDto bankAccountReponseDto = accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountReponseDto;
    }
}

