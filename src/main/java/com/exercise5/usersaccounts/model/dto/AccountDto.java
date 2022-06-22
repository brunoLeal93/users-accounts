package com.exercise5.usersaccounts.model.dto;

import java.util.Objects;

import com.exercise5.usersaccounts.model.AccountModel;

import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String accountCurrency;
    private PlainUserDto plainUserDto;

    public void setPlainUserDto(PlainUserDto plainUserDto) {
        this.plainUserDto = plainUserDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public static AccountDto from(AccountModel accountModel){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountModel.getId());
        accountDto.setAccountCurrency(accountModel.getAccountCurrency());
        if (Objects.nonNull(accountModel.getUser())){
            accountDto.setPlainUserDto(PlainUserDto.from(accountModel.getUser()));
        }
        return accountDto;
    }
}
