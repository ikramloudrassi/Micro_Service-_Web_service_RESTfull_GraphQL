package com.example.banqueacountservice.mappers;


import com.example.banqueacountservice.dto.BankAccountReponseDto;
import com.example.banqueacountservice.entities.BankAccount;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountReponseDto fromBankAccount(BankAccount bankAccount)
    {
        BankAccountReponseDto bankAccountReponseDto= new BankAccountReponseDto();
        BeanUtils.copyProperties(bankAccount,bankAccountReponseDto);
        return bankAccountReponseDto;

    }
}
