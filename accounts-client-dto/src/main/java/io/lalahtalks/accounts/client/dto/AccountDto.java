package io.lalahtalks.accounts.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class AccountDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("createdAt")
    private Instant createdAt;

}
