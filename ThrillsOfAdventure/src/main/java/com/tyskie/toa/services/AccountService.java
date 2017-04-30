package com.tyskie.toa.services;

import com.tyskie.toa.DAOs.AccountDAOImpl;

/**
 * Created by tyskie on 4/1/17.
 */
public class AccountService {
    private AccountDAOImpl accountDAO = new AccountDAOImpl();

    public boolean checkIfAccountExists(String username, String password) {
        return accountDAO.checkIfAccountExists(username, password);
    }

    public void registerAccount(String username, String password) {
        accountDAO.registerAccount(username, password);
    }
}
