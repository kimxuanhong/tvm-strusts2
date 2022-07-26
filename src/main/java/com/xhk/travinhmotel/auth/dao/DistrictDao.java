package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.District;

public class DistrictDao extends AbstractCrudDao<District, Long> {
    private DistrictDao() {
    }

    private static class SingletonHelper {
        private static final DistrictDao INSTANCE = new DistrictDao();
    }

    public static DistrictDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
