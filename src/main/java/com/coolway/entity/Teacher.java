package com.coolway.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
    private Long id;
    private String idNum;
    private String name;
    private Integer age;
    //这里一定要注意，要创建好，否则后续获取会空指针
    private Set<Subject> setSub = new HashSet<Subject>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Subject> getSetSub() {
        return setSub;
    }

    public void setSetSub(Set<Subject> setSub) {
        this.setSub = setSub;
    }
}
