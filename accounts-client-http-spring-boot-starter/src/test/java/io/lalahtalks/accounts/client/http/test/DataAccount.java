package io.lalahtalks.accounts.client.http.test;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import lombok.NoArgsConstructor;

import static io.lalahtalks.accounts.client.http.test.DataInstant.NOW;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DataAccount {

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_1_DTO = AccountCreationRequestDto.builder()
            .email("test@test.com")
            .password("my_password")
            .build();

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_2_DTO = AccountCreationRequestDto.builder()
            .email("already_exists@test.com")
            .password("my_password")
            .build();

    public static final AccountCreatedDto ACCOUNT_CREATED_DTO = AccountCreatedDto.builder()
            .accountId("account_1")
            .createdAt(NOW)
            .build();

}
