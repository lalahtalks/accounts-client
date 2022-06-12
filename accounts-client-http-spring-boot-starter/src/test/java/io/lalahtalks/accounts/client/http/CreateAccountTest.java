package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.contract.problem.AccountAlreadyExistsProblem;
import io.lalahtalks.accounts.client.http.test.SpringContextAware;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static io.lalahtalks.accounts.client.http.test.DataAccount.*;

class CreateAccountTest extends SpringContextAware {

    @Test
    void it_works() {
        var actual = accountsHttpClient.create(ACCOUNT_CREATION_REQUEST_1_DTO);
        StepVerifier.create(actual.log())
                .expectNext(ACCOUNT_CREATED_DTO)
                .verifyComplete();
    }

    @Test
    void account_already_exists() {
        var actual = accountsHttpClient.create(ACCOUNT_CREATION_REQUEST_2_DTO);
        StepVerifier.create(actual.log())
                .expectErrorMatches(error -> error instanceof AccountAlreadyExistsProblem &&
                        error.getMessage().equals("Account already exists: Some detail"))
                .verify();
    }

}
