package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Ward;

public class WardDao extends AbstractCrudDao<Ward, Long> {
    private WardDao() {
    }

    private static class SingletonHelper {
        private static final WardDao INSTANCE = new WardDao();
    }

    public static WardDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
