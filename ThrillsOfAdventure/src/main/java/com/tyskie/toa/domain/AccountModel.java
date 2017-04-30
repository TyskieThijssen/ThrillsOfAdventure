package com.tyskie.toa.domain;

import com.tyskie.toa.services.AccountService;

/**
 * Created by tyskie on 4/1/17.
 */
public class AccountModel {
    private AccountService accountService = new AccountService();

    public boolean checkIfAccountExists(String username, String password) {
        return accountService.checkIfAccountExists(username, password);
    }

    public void registerAccount(String username, String password) {
        accountService.registerAccount(username, password);
    }
}
