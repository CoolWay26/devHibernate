package com.coolway.dao;

import com.coolway.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    void saveTeacher(Teacher teacher);

    List<Teacher> queryTeacherAll();
}
