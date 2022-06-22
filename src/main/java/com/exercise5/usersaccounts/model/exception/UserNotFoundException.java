package com.exercise5.usersaccounts.model.exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(final Long id){
        super(MessageFormat.format("Could not find user with Id: {0}", id));
    }
}
