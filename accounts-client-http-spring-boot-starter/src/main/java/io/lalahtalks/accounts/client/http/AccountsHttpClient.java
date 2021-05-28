package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import io.lalahtalks.accounts.client.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import static io.lalahtalks.accounts.client.http.contract.AccountsHttpPaths.ACCOUNTS_PATH;
import static io.lalahtalks.accounts.client.http.contract.AccountsHttpPaths.ACCOUNT_PATH;

@RequiredArgsConstructor
public class AccountsHttpClient {

    private final AccountsHttpErrorHandler errorHandler;
    private final WebClient webClient;

    public AccountDto get(String accountId) {
        var uri = UriComponentsBuilder.fromUriString(ACCOUNT_PATH)
                .buildAndExpand(accountId)
                .toUriString();
        return webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(errorHandler::canBeHandled, errorHandler::handleError)
                .bodyToMono(AccountDto.class)
                .block();
    }

    public AccountCreatedDto create(AccountCreationRequestDto request) {
        return webClient.post()
                .uri(ACCOUNTS_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .onStatus(errorHandler::canBeHandled, errorHandler::handleError)
                .bodyToMono(AccountCreatedDto.class)
                .block();
    }

}
