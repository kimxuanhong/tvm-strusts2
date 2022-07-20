package com.xhk.travinhmotel.auth.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class HibernateUtil implements Serializable {
    private static final long serialVersionUID = 1L;

    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        String cfg = "hibernate.cfg.xml";
        sessionFactory = new Configuration().configure(cfg).buildSessionFactory();
    }

    private static class SingletonHelper {
        private static final HibernateUtil INSTANCE = new HibernateUtil();
    }

    public static HibernateUtil getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
