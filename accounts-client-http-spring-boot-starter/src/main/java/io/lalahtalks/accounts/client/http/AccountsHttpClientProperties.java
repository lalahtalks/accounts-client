package io.lalahtalks.accounts.client.http;

import io.lalahtalks.spring.http.client.HttpApiClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "lalahtalks.accounts-http-api")
public class AccountsHttpClientProperties implements HttpApiClientProperties {

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String url() {
        return url;
    }

}
