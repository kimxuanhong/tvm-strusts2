package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Address;

public class AddressDao extends AbstractCrudDao<Address, Long> {
    private AddressDao() {
    }

    private static class SingletonHelper {
        private static final AddressDao INSTANCE = new AddressDao();
    }

    public static AddressDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
