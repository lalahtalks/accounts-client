package io.lalahtalks.accounts.client.http.contract.problem;

import static org.zalando.problem.Status.CONFLICT;

public final class AccountAlreadyExistsProblem extends AccountsProblem {

    static final String TYPE = TYPE_PREFIX + "account-already-exists";
    private static final String TITLE = "Account already exists";

    public AccountAlreadyExistsProblem(String detail) {
        super(TYPE, TITLE, CONFLICT, detail);
    }

}
