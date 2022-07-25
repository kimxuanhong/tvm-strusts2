package com.xhk.travinhmotel.auth.service;

import com.xhk.travinhmotel.auth.dao.AccountDao;
import com.xhk.travinhmotel.auth.entity.Account;

import java.util.Optional;

public class AuthenticationService {

    private AuthenticationService() {
    }

    private static class SingletonHelper {
        private static final AuthenticationService INSTANCE = new AuthenticationService();
    }

    public static AuthenticationService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    private final AccountDao accountDao = AccountDao.getInstance();


    public boolean validate(String username,String password){
        Optional<Account> account = accountDao.findByEmail(username);

        return false;

    }


}
