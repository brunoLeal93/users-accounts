package com.exercise5.usersaccounts.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise5.usersaccounts.model.AccountModel;
import com.exercise5.usersaccounts.model.dto.AccountDto;
import com.exercise5.usersaccounts.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody final AccountDto accountDto){
        AccountModel accountModel = accountService.addAccount(AccountModel.from(accountDto));
        return new ResponseEntity<>(AccountDto.from(accountModel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts() {
        List<AccountModel> accounts = accountService.getAccounts();
        List<AccountDto> accountsDto = accounts.stream().map(AccountDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(accountsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable final Long id) {
        AccountModel account = accountService.getAccount(id);
        return new ResponseEntity<>(AccountDto.from(account), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable final Long id) {
        AccountModel account = accountService.deleteAccount(id);
        return new ResponseEntity<>(AccountDto.from(account), HttpStatus.OK);
    }
    
    @PutMapping(value = "{id}")
    public ResponseEntity<AccountDto> editAccount(@PathVariable final Long id, @RequestBody final AccountDto accountDto) {
        AccountModel editedAccount = accountService.editAccount(id, AccountModel.from(accountDto));
        return new ResponseEntity<>(AccountDto.from(editedAccount), HttpStatus.OK);
    }
}
