package com.example.banqueacountservice.web;

import com.example.banqueacountservice.dto.BankAccountReponseDto;
import com.example.banqueacountservice.dto.BankAccountRequestDto;
import com.example.banqueacountservice.entities.BankAccount;
import com.example.banqueacountservice.mappers.AccountMapper;
import com.example.banqueacountservice.repos.BankAccountRepository;
import com.example.banqueacountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

   public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper)
   {
       this.bankAccountRepository=bankAccountRepository;

       this.accountService = accountService;
       this.accountMapper = accountMapper;
   }
   @GetMapping("/bankAccounts")
   public List<BankAccount> bankAccounts()
   {
       return  bankAccountRepository.findAll();
   }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id)
    {
        return  bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountReponseDto save(@RequestBody BankAccountRequestDto requestDto)
    {

        return  accountService.AddAcount(requestDto);
    }

    @PutMapping ("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id ,@RequestBody BankAccount bankAccount)
    {
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
      if(bankAccount.getBalance()!=null)  account.setBalance(bankAccount.getBalance());
      if(bankAccount.getCreationdate()!=null)  account.setCreationdate(new Date());
      if(bankAccount.getType()!=null)  account.setType(
        bankAccount.getType());
      if(bankAccount.getCurrency()!=null)  account.setCurrency(bankAccount.getCurrency());
      return  bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount (@PathVariable String id)
    {
          bankAccountRepository.deleteById(id);
    }


}

