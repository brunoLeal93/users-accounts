package com.exercise5.usersaccounts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercise5.usersaccounts.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    
}
