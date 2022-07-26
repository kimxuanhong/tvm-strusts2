package com.xhk.travinhmotel.auth.service;

import com.xhk.travinhmotel.auth.dao.CityDao;

public class CityService {
    private CityService() {
    }

    private static class SingletonHelper {
        private static final CityService INSTANCE = new CityService();
    }

    public static CityService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    private final CityDao accountDao = CityDao.getInstance();
}
