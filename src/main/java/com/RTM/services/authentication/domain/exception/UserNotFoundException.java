package com.RTM.services.authentication.domain.exception;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = -7630066735832452688L;

    public UserNotFoundException(final String message) {
        super(message);
    }
}
