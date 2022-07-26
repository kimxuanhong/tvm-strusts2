package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.action.dto.QueryPredicate;
import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountDao extends AbstractCrudDao<Account, Long> {
    private AccountDao() {
    }

    private static class SingletonHelper {
        private static final AccountDao INSTANCE = new AccountDao();
    }

    public static AccountDao getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public final String findByEmailQuery = "SELECT a FROM Account a WHERE a.email = :email";
    public Optional<Account> findByEmail(String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);

        return fetchOne(findByEmailQuery, params);
    }

    public final String searchQuery = "SELECT a FROM Account a WHERE a.email = :email";
    public List<Account> findAll(QueryPredicate build) {
        return fetch(searchQuery, build.getParams());
    }
}
