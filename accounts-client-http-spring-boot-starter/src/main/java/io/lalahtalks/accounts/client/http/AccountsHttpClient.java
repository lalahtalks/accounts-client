package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import io.lalahtalks.accounts.client.http.contract.AccountsProblemType;
import io.lalahtalks.accounts.client.http.exception.AccountAlreadyExistsException;
import io.lalahtalks.spring.http.client.UnknownException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.zalando.problem.Problem;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountsHttpClient {

    private final WebClient webClient;

    public AccountCreatedDto create(AccountCreationRequestDto request) {
        return webClient.post()
                .uri("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, this::findFromClientResponse)
                .bodyToMono(AccountCreatedDto.class)
                .block();
    }

    private Mono<RuntimeException> findFromClientResponse(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(Problem.class)
                .map(this::findFromProblem);
    }

    private RuntimeException findFromProblem(Problem problem) {
        return Arrays.stream(AccountsProblemType.values())
                .filter(problemType -> problemType.getType().equals(problem.getType()))
                .flatMap(problemType -> from(problemType, problem.getDetail()).stream())
                .findAny()
                .orElseThrow(() -> UnknownException.of(problem.getType(), problem.getDetail()));
    }

    private Optional<RuntimeException> from(AccountsProblemType problemType, String detail) {
        RuntimeException e = null;

        if (problemType == AccountsProblemType.ACCOUNT_ALREADY_EXISTS) {
            e = new AccountAlreadyExistsException();
        }

        return Optional.ofNullable(e);
    }

}
