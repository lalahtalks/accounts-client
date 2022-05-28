package io.lalahtalks.accounts.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountCreationRequestDto(
        @JsonProperty("email") String email,
        @JsonProperty("username") String username,
        @JsonProperty("password") String password) {

    public static final class Builder {

        private String email;
        private String username;
        private String password;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public AccountCreationRequestDto build() {
            return new AccountCreationRequestDto(email, username, password);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
