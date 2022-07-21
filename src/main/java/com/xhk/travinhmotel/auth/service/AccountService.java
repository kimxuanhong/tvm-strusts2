package com.xhk.travinhmotel.auth.service;

import com.xhk.travinhmotel.auth.dao.AccountDao;
import com.xhk.travinhmotel.auth.entity.Account;

import java.util.List;

public class AccountService {
    private AccountService() {
    }

    private static class SingletonHelper {
        private static final AccountService INSTANCE = new AccountService();
    }

    public static AccountService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    private final AccountDao accountDao = AccountDao.getInstance();

    public Account getAccountById(Long id) {
        return accountDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account with id=%s not found!", id)));
    }

    public List<Account> getAccountList() {
        return accountDao.findAll();
    }
}
