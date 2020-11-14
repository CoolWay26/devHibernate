package com.coolway.service.impl;

import com.coolway.dao.TeacherDao;
import com.coolway.dao.impl.TeacherDaoImpl;
import com.coolway.entity.Teacher;
import com.coolway.service.TeacherService;
import com.coolway.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao = new TeacherDaoImpl();

    public void saveTeacher(Teacher teacher) {
        //获取绑定线程的Session
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        //执行Dao，如果出线异常-rollback
        try {
            teacherDao.saveTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        //提交事务/关闭事务
        transaction.commit();
    }
}
