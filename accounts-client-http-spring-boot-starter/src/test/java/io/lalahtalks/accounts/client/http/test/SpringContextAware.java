package io.lalahtalks.accounts.client.http.test;

import io.lalahtalks.accounts.client.http.AccountsHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestApplication.class)
@AutoConfigureWireMock(port = 0)
@ActiveProfiles("test")
public abstract class SpringContextAware {

    @Autowired
    protected AccountsHttpClient accountsHttpClient;

}
