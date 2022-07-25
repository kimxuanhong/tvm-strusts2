package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class AccountDao extends AbstractCrudDao<Account, Long> {
    private AccountDao() {
    }

    public Optional<Account> findByEmail(String username) {
//        PreparedStatement ps=con.prepareStatement(
//                "select * from user3333 where name=? and password=?");
//        ps.setString(1,username);
//        ps.setString(2,userpass);
//        ResultSet rs=ps.executeQuery();
        return Optional.empty();
    }

    private static class SingletonHelper {
        private static final AccountDao INSTANCE = new AccountDao();
    }

    public static AccountDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
