package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.contract.problem.AccountAlreadyExistsProblem;
import io.lalahtalks.accounts.client.http.test.SpringContextAware;
import org.junit.jupiter.api.Test;

import static io.lalahtalks.accounts.client.http.test.DataAccount.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CreateAccountTest extends SpringContextAware {

    @Test
    void it_works() {
        var actual = accountsHttpClient.create(ACCOUNT_CREATION_REQUEST_1_DTO);
        assertThat(actual).isEqualTo(ACCOUNT_CREATED_DTO);
    }

    @Test
    void account_already_exists() {
        assertThatExceptionOfType(AccountAlreadyExistsProblem.class)
                .isThrownBy(() -> accountsHttpClient.create(ACCOUNT_CREATION_REQUEST_2_DTO))
                .withMessage("Account already exists: Some detail");
    }

}
