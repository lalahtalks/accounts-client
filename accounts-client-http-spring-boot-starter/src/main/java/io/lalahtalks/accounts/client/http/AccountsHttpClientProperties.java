package io.lalahtalks.accounts.client.http;

import io.lalahtalks.spring.http.client.HttpApiClientProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "lalahtalks.accounts-http-api")
@Data
public class AccountsHttpClientProperties implements HttpApiClientProperties {

    private String url;

}
