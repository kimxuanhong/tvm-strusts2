package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Feedback;

public class FeedbackDao extends AbstractCrudDao<Feedback, Long> {
    private FeedbackDao() {
    }

    private static class SingletonHelper {
        private static final FeedbackDao INSTANCE = new FeedbackDao();
    }

    public static FeedbackDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
