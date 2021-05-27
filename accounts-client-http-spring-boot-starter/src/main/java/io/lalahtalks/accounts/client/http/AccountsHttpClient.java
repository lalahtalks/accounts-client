package io.lalahtalks.accounts.client.http;

import io.lalahtalks.accounts.client.dto.AccountCreatedDto;
import io.lalahtalks.accounts.client.dto.AccountCreationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class AccountsHttpClient {

    private final AccountsHttpErrorHandler errorHandler;
    private final WebClient webClient;

    public AccountCreatedDto create(AccountCreationRequestDto request) {
        return webClient.post()
                .uri("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .onStatus(errorHandler::canBeHandled, errorHandler::handleError)
                .bodyToMono(AccountCreatedDto.class)
                .block();
    }

}
