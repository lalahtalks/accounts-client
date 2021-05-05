package io.lalahtalks.accounts.client.http.test;

import io.lalahtalks.accounts.client.http.AccountsHttpClientAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AccountsHttpClientAutoConfiguration.class)
public class TestApplication {

}
