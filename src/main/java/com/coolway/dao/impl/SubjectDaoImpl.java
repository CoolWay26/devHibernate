package com.coolway.dao.impl;

import com.coolway.dao.SubjectDao;
import com.coolway.entity.Subject;
import com.coolway.utils.HibernateUtils;
import org.hibernate.Session;

public class SubjectDaoImpl implements SubjectDao {
    public void saveSubject(Subject subject) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(subject);
    }
}
