package org.synatovich;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int workExperience;
    private List<String> taskList;

    public User(String name, int workExperience, List<String> taskList) {
        this.name = name;
        this.workExperience = workExperience;
        this.taskList = taskList;
    }

    public User(String name, int workExperience) {
        this.name = name;
        this.workExperience = workExperience;
        this.taskList = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return workExperience == user.workExperience && Objects.equals(name, user.name) && Objects.equals(taskList, user.taskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskList.size());
    }

    @Override
    public int compareTo(User o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "{" + name +
                ", workExperience=" + workExperience +
                ", taskList=" + taskList.size() + "}";
    }
}
