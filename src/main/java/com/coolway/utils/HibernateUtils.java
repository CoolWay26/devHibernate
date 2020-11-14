package com.coolway.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    //只有一个SessionFactory
    private static SessionFactory sessionFactory = null;

    static {
        //加载配置
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session openSession() {
        if (sessionFactory != null) {
            return sessionFactory.openSession();
        } else {
            return null;
        }
    }

    public static Session getCurrentSession() {
        if (sessionFactory != null) {
            return sessionFactory.getCurrentSession();
        } else {
            return null;
        }
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}
