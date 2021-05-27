package io.lalahtalks.accounts.client.http.exception;

public final class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String message) {
        super(message);
    }

}
