package io.lalahtalks.accounts.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record AccountCreatedDto(
        @JsonProperty("accountId") String accountId,
        @JsonProperty("createdAt") Instant createdAt) {

    public static final class Builder {

        private String accountId;
        private Instant createdAt;

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountCreatedDto build() {
            return new AccountCreatedDto(accountId, createdAt);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
