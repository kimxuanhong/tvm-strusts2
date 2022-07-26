package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Category;

public class CategoryDao extends AbstractCrudDao<Category, Long> {
    private CategoryDao() {
    }

    private static class SingletonHelper {
        private static final CategoryDao INSTANCE = new CategoryDao();
    }

    public static CategoryDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
