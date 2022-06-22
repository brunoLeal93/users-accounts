package com.exercise5.usersaccounts.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.exercise5.usersaccounts.model.UserModel;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String userName;
    public String getUserName() {
        return userName;
    }

    private List<AccountDto> accountsDto = new ArrayList<>();

    public List<AccountDto> getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(List<AccountDto> accountsDto) {
        this.accountsDto = accountsDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static UserDto from(UserModel userModel){
        UserDto userDto = new UserDto();
        userDto.setId(userModel.getId());
        userDto.setUserName(userModel.getUserName());
        userDto.setAccountsDto(userModel.getAccounts().stream().map(AccountDto::from).collect(Collectors.toList()));
        return userDto;
    }
}
