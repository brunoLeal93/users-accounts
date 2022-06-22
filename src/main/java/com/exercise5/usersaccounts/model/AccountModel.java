package com.exercise5.usersaccounts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exercise5.usersaccounts.model.dto.AccountDto;

import lombok.Data;

@Data
@Entity
@Table(name="Account")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountCurrency;
    @ManyToOne
    private UserModel user;
    
    public void setUser(UserModel user) {
        this.user = user;
    }
    public UserModel getUser() {
        return user;
    }
    public String getAccountCurrency() {
        return accountCurrency;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
   
    public static AccountModel from(AccountDto accountDto){
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountCurrency(accountDto.getAccountCurrency());
        return accountModel;
    }

    
    
}
