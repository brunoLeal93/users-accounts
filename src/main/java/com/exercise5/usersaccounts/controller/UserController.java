package com.exercise5.usersaccounts.controller;

import java.io.Console;
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

import com.exercise5.usersaccounts.model.UserModel;
import com.exercise5.usersaccounts.model.dto.UserDto;
import com.exercise5.usersaccounts.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody final UserDto userDto){
        System.out.println(userDto);
        UserModel userModel = userService.addUser(UserModel.from(userDto));
        return new ResponseEntity<>(UserDto.from(userModel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserModel> users = userService.getUsers();
        List<UserDto> usersDto = users.stream().map(UserDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable final Long id) {
        UserModel user = userService.getUser(id);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable final Long id) {
        UserModel user = userService.deleteUser(id);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }
    
    @PutMapping(value = "{id}")
    public ResponseEntity<UserDto> editUser(@PathVariable final Long id, @RequestBody final UserDto userDto) {
        UserModel editedUser = userService.editUser(id, UserModel.from(userDto));
        return new ResponseEntity<>(UserDto.from(editedUser), HttpStatus.OK);
    }

    @PostMapping(value = "{userId}/accounts/{accountId}/add")
    public ResponseEntity<UserDto> addAccountToUser(@PathVariable final Long userId, @PathVariable final Long accountId){
        UserModel userModel = userService.addAccountToUser(userId, accountId);
        return new ResponseEntity<>(UserDto.from(userModel), HttpStatus.OK);
    }

    @DeleteMapping(value = "{userId}/accounts/{accountId}/remove")
    public ResponseEntity<UserDto> removeAccountToUser(@PathVariable final Long userId, @PathVariable final Long accountId){
        UserModel userModel = userService.removeAccountFromUser(userId, accountId);
        return new ResponseEntity<>(UserDto.from(userModel), HttpStatus.OK);
    }
}
