package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.AbstractCrudDao;
import com.xhk.travinhmotel.auth.entity.Contact;

public class ContactDao extends AbstractCrudDao<Contact, Long> {
    private ContactDao() {
    }

    private static class SingletonHelper {
        private static final ContactDao INSTANCE = new ContactDao();
    }

    public static ContactDao getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
