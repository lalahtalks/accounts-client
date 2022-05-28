package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.contract.problem.AccountNotFoundProblem;
import io.lalahtalks.accounts.client.http.test.SpringContextAware;
import org.junit.jupiter.api.Test;

import static io.lalahtalks.accounts.client.http.test.DataAccount.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GetAccountTest extends SpringContextAware {

    @Test
    void it_works() {
        var actual = accountsHttpClient.get(ACCOUNT_1_ID_VALUE);
        assertThat(actual).isEqualTo(ACCOUNT_1_DTO);
    }

    @Test
    void account_not_found() {
        assertThatExceptionOfType(AccountNotFoundProblem.class)
                .isThrownBy(() -> accountsHttpClient.get(ACCOUNT_2_ID_VALUE))
                .withMessage("Account not found: Some detail");
    }

}
