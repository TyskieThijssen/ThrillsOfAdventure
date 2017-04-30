package com.tyskie.toa.DAOs;

/**
 * Created by tyskie on 4/1/17.
 */
public interface AccountDAO {
    boolean checkIfAccountExists(String username, String password);

    void registerAccount(String username, String password);
}
