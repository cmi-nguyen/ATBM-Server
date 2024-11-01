package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    // Save
    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
    // Read
    @Override
    public List<Account> fetchAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Account account, int accountID) {
        Account accDB = accountRepository.findById(accountID).get();
        if (Objects.nonNull(account.getAccountID())){
            accDB.setAccountID(account.getAccountID());
        }
        if (Objects.nonNull(account.getAccountName())&&!"".equalsIgnoreCase(account.getAccountName())){
            accDB.setAccountName(account.getAccountName());
        }
        if (Objects.nonNull(account.getStatus())){
            accDB.setStatus(account.getStatus());
        }
        if (Objects.nonNull(account.getPhone())&&!"".equalsIgnoreCase(account.getPhone())){
            accDB.setPassword(account.getPhone());
        }
        if (Objects.nonNull(account.getEmail())&&!"".equalsIgnoreCase(account.getEmail())){
            accDB.setEmail(account.getEmail());
        }
        if (Objects.nonNull(account.getAddress())&&!"".equalsIgnoreCase(account.getAddress())){
            accDB.setAddress(account.getAddress());
        }
        if (Objects.nonNull(account.getPin())&&!"".equalsIgnoreCase(account.getPin())){
            accDB.setPin(account.getPin());
        }
        if (Objects.nonNull(account.getType())){
            accDB.setType(account.getType());
        }

        accDB.setGender(account.isGender());


        return accountRepository.save(accDB);
    }

    @Override
    public void deleteAccountByID(int accountID) {
        accountRepository.deleteById(accountID);
    }
}
