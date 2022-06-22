package com.exercise5.usersaccounts.model.exception;

import java.text.MessageFormat;

public class AccountIsInUseException extends RuntimeException{
    public AccountIsInUseException(final Long accountId, final Long userId){
        super(MessageFormat.format("Account: {0} is already in use by User: {1}", accountId, userId));
    }
    
}
