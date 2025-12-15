package com.skillnext1;


public class Student {
    private int id;
    private String name;
    private int sem;
    private String dept;

    // Constructor for inserting new student
    public Student(String name, int sem, String dept) {
        this.name = name;
        this.sem = sem;
        this.dept = dept;
    }

    // Constructor for retrieving
    public Student(int id, String name, int sem, String dept) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.dept = dept;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getSem() { return sem; }
    public String getDept() { return dept; }

    @Override
    public String toString() {
        return id + " | " + name + " | Sem: " + sem + " | Dept: " + dept;
    }
}
