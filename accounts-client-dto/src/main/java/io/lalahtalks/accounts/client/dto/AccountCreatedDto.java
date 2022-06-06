package io.lalahtalks.accounts.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record AccountCreatedDto(
        @JsonProperty("accountId") String accountId,
        @JsonProperty("createdAt") Instant createdAt) {

}
