package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Motel;

public class MotelDao extends AbstractCrudDao<Motel, Long> {
    private MotelDao() {
    }

    private static class SingletonHelper {
        private static final MotelDao INSTANCE = new MotelDao();
    }

    public static MotelDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
