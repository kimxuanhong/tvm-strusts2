package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.City;

public class CityDao extends AbstractCrudDao<City, Long> {
    private CityDao() {
    }

    private static class SingletonHelper {
        private static final CityDao INSTANCE = new CityDao();
    }

    public static CityDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
