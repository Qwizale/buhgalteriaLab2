package com.example.NachislenieZP.models;

public final class EmployeeModel {

    private static int autoincrement = 0;
    private long id;
    private String name;
    private String post;
    private int salary;

    public EmployeeModel(String name, String post, int salary) {
        this.id = autoincrement++;
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
