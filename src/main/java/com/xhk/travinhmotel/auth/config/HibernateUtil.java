package com.xhk.travinhmotel.auth.config;

import com.opensymphony.xwork2.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class HibernateUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final transient Logger log = LogManager.getLogger(HibernateUtil.class);

    private final SessionFactory sessionFactory;

    @Inject("session")
    private HibernateUtil() {
        log.info("Init hibernate...");

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
