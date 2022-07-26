package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Utility;

public class UtilityDao extends AbstractCrudDao<Utility, Long> {
    private UtilityDao() {
    }

    private static class SingletonHelper {
        private static final UtilityDao INSTANCE = new UtilityDao();
    }

    public static UtilityDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
