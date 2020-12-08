package com.example.app_uniportal.bussiness.grades.entity;

public class Evaluation {
    private String matter;
    private String grade;

    public Evaluation() {}
    public Evaluation(String matter, String grade) {
        this.matter = matter;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String getMatter() {
        return matter;
    }
}
