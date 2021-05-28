package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.exception.AccountNotFoundException;
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
public class GetAccountTest {

    @Autowired
    private AccountsHttpClient accountsHttpClient;

    @Test
    void it_works() {
        var actual = accountsHttpClient.get(ACCOUNT_1_ID_VALUE);
        assertThat(actual).isEqualTo(ACCOUNT_1_DTO);
    }

    @Test
    void account_not_found() {
        assertThatExceptionOfType(AccountNotFoundException.class)
                .isThrownBy(() -> accountsHttpClient.get(ACCOUNT_2_ID_VALUE));
    }

}
