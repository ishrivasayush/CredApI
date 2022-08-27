package com.CredApI.CredApI.requeste;

public class CreateRequest {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public CreateRequest(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public void setAge(int Age) {
        this.age = age;
    }
}
