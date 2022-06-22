package com.exercise5.usersaccounts.model.dto;

import com.exercise5.usersaccounts.model.UserModel;

import lombok.Data;

@Data
public class PlainUserDto {
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }

    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static PlainUserDto from(UserModel userModel){
        PlainUserDto plainUserDto = new PlainUserDto();
        plainUserDto.setId(userModel.getId());
        plainUserDto.setUserName(userModel.getUserName());
        return plainUserDto;
    }
}
