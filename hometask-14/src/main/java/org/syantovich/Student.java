package org.syantovich;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private boolean isMan;
    private int age;
    private List<String> subjects;

    public Student(String name, boolean isMan, int age, List<String> subjects) {
        this.name = name;
        this.isMan = isMan;
        this.age = age;
        this.subjects = subjects;
    }

    public Student(String name, boolean isMan, int age) {
        this(name,isMan,age,new ArrayList<String>());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isMan=" + isMan +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public boolean isMan() {
        return isMan;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}