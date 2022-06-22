package com.exercise5.usersaccounts.model.exception;

import java.text.MessageFormat;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(final Long id){
        super(MessageFormat.format("Could not find account with Id: {0}", id));
    }
}
