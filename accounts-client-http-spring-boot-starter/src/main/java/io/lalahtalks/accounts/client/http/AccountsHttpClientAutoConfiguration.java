package io.lalahtalks.accounts.client.http;

import io.lalahtalks.spring.http.client.WebClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableConfigurationProperties(AccountsHttpClientProperties.class)
@RequiredArgsConstructor
public class AccountsHttpClientAutoConfiguration {

    private final AccountsHttpClientProperties clientProperties;
    private final WebClientFactory webClientFactory;

    @Bean
    public AccountsHttpClient accountsHttpClient() {
        var webClient = webClientFactory.create(clientProperties);
        return new AccountsHttpClient(webClient);
    }

}
