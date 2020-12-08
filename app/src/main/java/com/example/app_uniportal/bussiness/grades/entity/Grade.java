package com.example.app_uniportal.bussiness.grades.entity;

import java.util.List;

public class Grade {
    private String userDocument;
    private List<Evaluation> evaluations;

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Grade(String userDocument, List<Evaluation> evaluations) {
        this.userDocument = userDocument;
        this.evaluations = evaluations;
    }
}
