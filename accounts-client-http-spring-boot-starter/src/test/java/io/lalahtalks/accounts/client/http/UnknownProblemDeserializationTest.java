package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.contract.problem.UnknownAccountsProblem;
import io.lalahtalks.accounts.client.http.test.SpringContextAware;
import org.junit.jupiter.api.Test;

import static io.lalahtalks.accounts.client.http.test.DataAccount.ACCOUNT_3_ID_VALUE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UnknownProblemDeserializationTest extends SpringContextAware {

    @Test
    void it_works() {
        assertThatExceptionOfType(UnknownAccountsProblem.class)
                .isThrownBy(() -> accountsHttpClient.get(ACCOUNT_3_ID_VALUE))
                .withMessage("Unknown problem: Some detail");
    }

}
