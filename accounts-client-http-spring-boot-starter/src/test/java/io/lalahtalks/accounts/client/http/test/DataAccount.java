package io.lalahtalks.accounts.client.http.test;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import io.lalahtalks.accounts.client.dto.AccountDto;

import static io.lalahtalks.accounts.client.http.test.DataInstant.NOW;

public class DataAccount {

    public static final String ACCOUNT_1_ID_VALUE = "account_1";
    public static final String ACCOUNT_2_ID_VALUE = "account_2";
    public static final String ACCOUNT_3_ID_VALUE = "account_3";
    public static final String ACCOUNT_1_EMAIL_VALUE = "test@test.com";
    public static final String ACCOUNT_1_USERNAME_VALUE = "User 1";
    public static final String A_PASSWORD = "my_password";

    public static final AccountDto ACCOUNT_1_DTO = new AccountDto(
            ACCOUNT_1_ID_VALUE,
            ACCOUNT_1_EMAIL_VALUE,
            ACCOUNT_1_USERNAME_VALUE,
            NOW);

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_1_DTO = new AccountCreationRequestDto(
            ACCOUNT_1_EMAIL_VALUE,
            ACCOUNT_1_USERNAME_VALUE,
            A_PASSWORD);

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_2_DTO = new AccountCreationRequestDto(
            "already_exists@test.com",
            ACCOUNT_1_USERNAME_VALUE,
            A_PASSWORD);

    public static final AccountCreatedDto ACCOUNT_CREATED_DTO = new AccountCreatedDto(ACCOUNT_1_ID_VALUE, NOW);

    private DataAccount() {

    }

}
