package io.lalahtalks.accounts.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record AccountDto(
        @JsonProperty("id") String id,
        @JsonProperty("email") String email,
        @JsonProperty("username") String username,
        @JsonProperty("createdAt") Instant createdAt) {

}
