package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import io.lalahtalks.accounts.client.dto.AccountDto;
import io.lalahtalks.accounts.client.http.contract.problem.AccountsProblem;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import static io.lalahtalks.accounts.client.http.contract.AccountsHttpPaths.ACCOUNTS_PATH;
import static io.lalahtalks.accounts.client.http.contract.AccountsHttpPaths.ACCOUNT_PATH;

public class AccountsHttpClient {

    private final WebClient webClient;

    public AccountsHttpClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<AccountDto> get(String accountId) {
        var uri = UriComponentsBuilder.fromUriString(ACCOUNT_PATH)
                .buildAndExpand(accountId)
                .toUriString();
        return webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handle)
                .bodyToMono(AccountDto.class);
    }

    public Mono<AccountCreatedDto> create(AccountCreationRequestDto request) {
        return webClient.post()
                .uri(ACCOUNTS_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handle)
                .bodyToMono(AccountCreatedDto.class);
    }

    private Mono<? extends Throwable> handle(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(AccountsProblem.class);
    }

}
