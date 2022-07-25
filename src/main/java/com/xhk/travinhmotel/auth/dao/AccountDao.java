package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.dao.base.Query;
import com.xhk.travinhmotel.auth.entity.Account;

import java.lang.reflect.Method;

public class AccountDao extends AbstractCrudDao<Account, Long> {
    private AccountDao() {
    }


    @Query(value = "SELECT a FROM Account a WHERE a.email = :email")
    public Method findByEmail(String email) {
        class Inner {}
        return Inner.class.getEnclosingMethod();
    }

    private static class SingletonHelper {
        private static final AccountDao INSTANCE = new AccountDao();
    }

    public static AccountDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
