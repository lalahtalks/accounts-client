package io.lalahtalks.accounts.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class AccountCreatedDto {

    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("createdAt")
    private Instant createdAt;

}
