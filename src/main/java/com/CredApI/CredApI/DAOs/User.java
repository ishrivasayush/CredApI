package com.CredApI.CredApI.DAOs;

public class User {
    private int id;
    private String name;

    public User(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int age;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", name='" +this.name + '\'' +
                ", age=" + this.age +
                ", address='" + this.address + '\'' +
                '}';
    }
}
