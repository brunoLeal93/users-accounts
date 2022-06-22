package com.exercise5.usersaccounts.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise5.usersaccounts.model.AccountModel;
import com.exercise5.usersaccounts.model.exception.AccountNotFoundException;
import com.exercise5.usersaccounts.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public AccountModel addAccount(AccountModel accountModel){
        return accountRepository.save(accountModel);
    }
    public List<AccountModel> getAccounts(){
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public AccountModel getAccount(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }

    public AccountModel deleteAccount(Long id){
        AccountModel accountModel = getAccount(id);
        accountRepository.delete(accountModel);
        return accountModel;
    }

    @Transactional
    public AccountModel editAccount(Long id, AccountModel accountModel){
        AccountModel accountToEdit = getAccount(id);
        accountToEdit.setAccountCurrency(accountModel.getAccountCurrency());
        return accountToEdit;
    }
}