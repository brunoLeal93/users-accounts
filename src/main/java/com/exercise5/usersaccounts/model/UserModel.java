package com.exercise5.usersaccounts.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.exercise5.usersaccounts.model.dto.UserDto;

import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="users_id")
    private List<AccountModel> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<AccountModel> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountModel> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(AccountModel account){
        accounts.add(account);
    }

    public void removeAccount(AccountModel account){
        accounts.remove(account);
    }

    public static UserModel from(UserDto accountDto){
        UserModel userModel = new UserModel();
        userModel.setUserName(accountDto.getUserName());
        return userModel;
    }

}