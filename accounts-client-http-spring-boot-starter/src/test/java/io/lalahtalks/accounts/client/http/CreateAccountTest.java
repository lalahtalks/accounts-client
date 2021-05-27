package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import io.lalahtalks.accounts.client.http.exception.AccountAlreadyExistsException;
import io.lalahtalks.accounts.client.http.test.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest(classes = TestApplication.class)
@AutoConfigureWireMock(port = 0)
@ActiveProfiles("test")
public class CreateAccountTest {

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_1_DTO = AccountCreationRequestDto.builder()
            .email("test@test.com")
            .password("my_password")
            .build();

    public static final AccountCreationRequestDto ACCOUNT_CREATION_REQUEST_2_DTO = AccountCreationRequestDto.builder()
            .email("already_exists@test.com")
            .password("my_password")
            .build();

    private static final AccountCreatedDto ACCOUNT_CREATED_DTO = AccountCreatedDto.builder()
            .accountId("account_1")
            .createdAt(Instant.parse("2021-06-01T00:00:00Z"))
            .build();

    @Autowired
    private AccountsHttpClient accountsHttpClient;

    @Test
    void it_works() {
        var actual = accountsHttpClient.create(ACCOUNT_CREATION_REQUEST_1_DTO);
        assertThat(actual).isEqualTo(ACCOUNT_CREATED_DTO);
    }

    @Test
    void account_already_exists() {
        assertThatExceptionOfType(AccountAlreadyExistsException.class)
                .isThrownBy(() -> accountsHttpClient.create(ACCOUNT_CREATION_REQUEST_2_DTO));
    }

}
