package io.lalahtalks.accounts.client.http.contract;

public class AccountsHttpPaths {

    public static final String ACCOUNTS_PATH = "/accounts";
    public static final String ACCOUNT_ID = "accountId";
    public static final String ACCOUNT_ID_PLACEHOLDER = '{' + ACCOUNT_ID + '}';
    public static final String ACCOUNT_ID_PATH = '/' + ACCOUNT_ID_PLACEHOLDER;
    public static final String ACCOUNT_PATH = ACCOUNTS_PATH + ACCOUNT_ID_PATH;

    private AccountsHttpPaths() {

    }

}
