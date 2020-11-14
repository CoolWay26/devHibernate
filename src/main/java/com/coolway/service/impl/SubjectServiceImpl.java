package com.coolway.service.impl;

import com.coolway.dao.SubjectDao;
import com.coolway.dao.impl.SubjectDaoImpl;
import com.coolway.entity.Subject;
import com.coolway.service.SubjectService;
import com.coolway.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SubjectServiceImpl implements SubjectService {
    private SubjectDao subjectDao = new SubjectDaoImpl();

    public void saveSubject(Subject subject) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            subjectDao.saveSubject(subject);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        transaction.commit();
    }
}
