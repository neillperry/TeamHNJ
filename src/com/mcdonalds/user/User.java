package com.mcdonalds.user;

public class User {
    private String name = "guest";
    private int age;

    User(String name, int age) {
        setAge(age);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // BUSINESS METHODS
    public boolean payForOrder() {
        return true;
    }
}
