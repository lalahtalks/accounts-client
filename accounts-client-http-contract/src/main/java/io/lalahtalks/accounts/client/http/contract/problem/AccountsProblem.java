package io.lalahtalks.accounts.client.http.contract.problem;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AccountAlreadyExistsProblem.class, name = AccountAlreadyExistsProblem.TYPE),
        @JsonSubTypes.Type(value = AccountNotFoundProblem.class, name = AccountNotFoundProblem.TYPE)})
public abstract class AccountsProblem extends AbstractThrowableProblem {

    static final String TYPE_PREFIX = "urn:lalahtalks:problem:accounts:";

    public AccountsProblem(String type, String title, Status status, String detail) {
        super(URI.create(type), title, status, detail);
    }

}