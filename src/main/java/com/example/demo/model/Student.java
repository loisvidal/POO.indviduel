package com.example.demo.model;
import java.util.ArrayList;
import java.util.List;
public class Student extends Person{
    private String studentID;
    private List<Double> grades;

    public Student(String name, int age) {
        super(name, age);
        this.grades = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + getStudentID() + ", Average Grade: " + getAverageGrade();
    }
}
