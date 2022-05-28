package io.lalahtalks.accounts.client.http;

import io.lalahtalks.spring.http.client.WebClientFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableConfigurationProperties(AccountsHttpClientProperties.class)
public class AccountsHttpClientAutoConfiguration {

    private final AccountsHttpClientProperties clientProperties;
    private final WebClientFactory webClientFactory;

    public AccountsHttpClientAutoConfiguration(AccountsHttpClientProperties clientProperties,
                                               WebClientFactory webClientFactory) {
        this.clientProperties = clientProperties;
        this.webClientFactory = webClientFactory;
    }

    @Bean
    public AccountsHttpClient accountsHttpClient() {
        var webClient = webClientFactory.create(clientProperties);
        return new AccountsHttpClient(webClient);
    }

}
