package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.exception.AccountAlreadyExistsException;
import io.lalahtalks.accounts.client.http.test.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

import static io.lalahtalks.accounts.client.http.test.DataAccount.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest(classes = TestApplication.class)
@AutoConfigureWireMock(port = 0)
@ActiveProfiles("test")
class CreateAccountTest {

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
