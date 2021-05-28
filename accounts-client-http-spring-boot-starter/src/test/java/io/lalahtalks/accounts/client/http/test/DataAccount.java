package io.lalahtalks.accounts.client.http.test;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import io.lalahtalks.accounts.client.dto.AccountDto;
import lombok.NoArgsConstructor;

import static io.lalahtalks.accounts.client.http.test.DataInstant.NOW;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DataAccount {

    public static final String ACCOUNT_1_ID_VALUE = "account_1";
    public static final String ACCOUNT_2_ID_VALUE = "account_2";
    public static final String ACCOUNT_1_EMAIL_VALUE = "test@test.com";
    public static final String A_PASSWORD = "my_password";

    public static final AccountDto ACCOUNT_1_DTO = AccountDto.builder()
            .id(ACCOUNT_1_ID_VALUE)
            .email(ACCOUNT_1_EMAIL_VALUE)
            .createdAt(NOW)
            .build();

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_1_DTO = AccountCreationRequestDto.builder()
            .email(ACCOUNT_1_EMAIL_VALUE)
            .password(A_PASSWORD)
            .build();

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_2_DTO = AccountCreationRequestDto.builder()
            .email("already_exists@test.com")
            .password(A_PASSWORD)
            .build();

    public static final AccountCreatedDto ACCOUNT_CREATED_DTO = AccountCreatedDto.builder()
            .accountId(ACCOUNT_1_ID_VALUE)
            .createdAt(NOW)
            .build();

}
