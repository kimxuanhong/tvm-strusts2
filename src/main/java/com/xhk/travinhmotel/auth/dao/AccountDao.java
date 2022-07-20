package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Account;

public class AccountDao extends AbstractCrudDao<Account, Long> {
    private AccountDao() {
    }

    private static class SingletonHelper {
        private static final AccountDao INSTANCE = new AccountDao();
    }

    public static AccountDao getInstance() {
        return AccountDao.SingletonHelper.INSTANCE;
    }
}
