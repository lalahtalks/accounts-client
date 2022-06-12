package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.contract.problem.AccountNotFoundProblem;
import io.lalahtalks.accounts.client.http.test.SpringContextAware;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static io.lalahtalks.accounts.client.http.test.DataAccount.*;

class GetAccountTest extends SpringContextAware {

    @Test
    void it_works() {
        var actual = accountsHttpClient.get(ACCOUNT_1_ID_VALUE);
        StepVerifier.create(actual.log())
                .expectNext(ACCOUNT_1_DTO)
                .verifyComplete();
    }

    @Test
    void account_not_found() {
        var actual = accountsHttpClient.get(ACCOUNT_2_ID_VALUE);
        StepVerifier.create(actual.log())
                .expectErrorMatches(error -> error instanceof AccountNotFoundProblem
                        && error.getMessage().equals("Account not found: Some detail"))
                .verify();
    }

}
