package com.finabil.springrest.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private  String fullName;
    private Integer age;
    private List<String> hobbies;

    public User(){

    }

    public User(String fullName, Integer age, List<String> hobbies) {
        this.fullName = fullName;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
