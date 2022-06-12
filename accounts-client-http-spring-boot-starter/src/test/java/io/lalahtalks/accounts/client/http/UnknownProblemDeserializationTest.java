package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.contract.problem.UnknownAccountsProblem;
import io.lalahtalks.accounts.client.http.test.SpringContextAware;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static io.lalahtalks.accounts.client.http.test.DataAccount.ACCOUNT_3_ID_VALUE;

class UnknownProblemDeserializationTest extends SpringContextAware {

    @Test
    void it_works() {
        var actual = accountsHttpClient.get(ACCOUNT_3_ID_VALUE);
        StepVerifier.create(actual.log())
                .expectErrorMatches(error -> error instanceof UnknownAccountsProblem
                        && error.getMessage().equals("Unknown problem: Some detail"))
                .verify();
    }

}
