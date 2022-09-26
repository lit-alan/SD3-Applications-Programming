package com.lit.src;

public class Person {
    private String name;
    private int age;
    private String address;
    private String pps;

    public Person(String name, int age, String address, String pps) {

        this.setName(name);
        this.setAge(age);
        this.setAddress(address);
        this.setPps(pps);
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

    public String getPps() {
        return pps;
    }

    public void setPps(String pps) {
        this.pps = pps;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", pps='" + pps + '\'' +
                '}';
    }
}
