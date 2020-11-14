package com.coolway.dao.impl;

import com.coolway.entity.Teacher;
import com.coolway.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.coolway.dao.TeacherDao;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    public void saveTeacher(Teacher teacher) {
        //Dao层只负责交互数据库，不进行其他任何操作
        Session session = HibernateUtils.getCurrentSession();
        session.save(teacher);
    }

    public List<Teacher> queryTeacherAll() {
        Session session = HibernateUtils.getCurrentSession();
//        Query query = session.createQuery("from teacher");
//        List<Teacher> list = query.list();
//        Criteria criteria = session.createCriteria(Teacher.class);
//        criteria.setProjection(Projections.rowCount());
//        List<Teacher> list = criteria.list();
        SQLQuery sqlQuery = session.createSQLQuery("select * from teacher");
        //封装到对象中
        sqlQuery.addEntity(Teacher.class);
        List<Teacher> list = sqlQuery.list();
        return list;
    }
}
