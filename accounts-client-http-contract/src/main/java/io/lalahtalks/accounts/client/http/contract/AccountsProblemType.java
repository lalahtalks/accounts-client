package io.lalahtalks.accounts.client.http.contract;

import io.lalahtalks.spring.problem.ProblemType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.zalando.problem.Status;

import java.net.URI;

@RequiredArgsConstructor
@Getter
public enum AccountsProblemType implements ProblemType {

    ACCOUNT_ALREADY_EXISTS(
            URI.create("urn:lalahtalks:problem:accounts:account-already-exists"),
            "Account already exists",
            Status.CONFLICT),

    ;

    private final URI type;
    private final String title;
    private final Status httpStatus;

}
