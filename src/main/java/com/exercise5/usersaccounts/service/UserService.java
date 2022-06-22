package com.exercise5.usersaccounts.service;

import com.exercise5.usersaccounts.model.AccountModel;
import com.exercise5.usersaccounts.model.UserModel;
import com.exercise5.usersaccounts.model.exception.AccountIsInUseException;
import com.exercise5.usersaccounts.model.exception.UserNotFoundException;
import com.exercise5.usersaccounts.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AccountService accountService;

    @Autowired
    public UserService(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    public UserModel addUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> getUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public UserModel getUser(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserModel deleteUser(Long id){
        UserModel userModel = getUser(id);
        userRepository.delete(userModel);
        return userModel;
    }

    @Transactional
    public UserModel editUser(Long id, UserModel userModel){
        UserModel accountToEdit = getUser(id);
        accountToEdit.setUserName(userModel.getUserName());
        return accountToEdit;
    }

    @Transactional
    public UserModel addAccountToUser(Long userId, Long accountId){
        UserModel userModel = getUser(userId);
        AccountModel accountModel = accountService.getAccount(accountId);
        if (Objects.nonNull(accountModel.getUser())){
            throw new AccountIsInUseException(accountId, accountModel.getUser().getId());
        }
        userModel.addAccount(accountModel);
        accountModel.setUser(userModel);
        return userModel;
    }

    @Transactional
    public UserModel removeAccountFromUser(Long userId, Long accountId){
        UserModel userModel = getUser(userId);
        AccountModel accountModel = accountService.getAccount(accountId);
        userModel.removeAccount(accountModel);
        return userModel;
    }
  
}
