package io.lalahtalks.accounts.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record AccountDto(
        @JsonProperty("id") String id,
        @JsonProperty("email") String email,
        @JsonProperty("username") String username,
        @JsonProperty("createdAt") Instant createdAt) {

    public static final class Builder {

        private String id;
        private String email;
        private String username;
        private Instant createdAt;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountDto build() {
            return new AccountDto(id, email, username, createdAt);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
