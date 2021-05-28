package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.http.contract.AccountsProblemType;
import io.lalahtalks.accounts.client.http.exception.AccountAlreadyExistsException;
import io.lalahtalks.accounts.client.http.exception.AccountNotFoundException;
import io.lalahtalks.accounts.client.http.exception.UnknownAccountsErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.zalando.problem.Problem;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static io.lalahtalks.accounts.client.http.contract.AccountsProblemType.ACCOUNT_ALREADY_EXISTS;
import static io.lalahtalks.accounts.client.http.contract.AccountsProblemType.ACCOUNT_NOT_FOUND;

@Component
public class AccountsHttpErrorHandler {

    private final Map<URI, Function<String, Exception>> errorMappings = new HashMap<>();

    public AccountsHttpErrorHandler() {
        errorMappings.put(ACCOUNT_NOT_FOUND.getType(), AccountNotFoundException::new);
        errorMappings.put(ACCOUNT_ALREADY_EXISTS.getType(), AccountAlreadyExistsException::new);
    }

    public boolean canBeHandled(HttpStatus status) {
        return Stream.of(AccountsProblemType.values())
                .anyMatch(errorType -> errorType.getHttpStatus().getStatusCode() == status.value());
    }

    public Mono<Throwable> handleError(ClientResponse response) {
        return response.bodyToMono(Problem.class)
                .map(this::toError);
    }

    private Exception toError(Problem problem) {
        return errorMappings.getOrDefault(problem.getType(), UnknownAccountsErrorException::new)
                .apply(problem.getDetail());
    }

}
