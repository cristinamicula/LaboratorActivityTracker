package com.example.assignment_2.bussiness.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Attendance {
    private Long id;

    private Student student;
    private Laboratory laboratory;

    public void setId(Long id) {
        this.id = id;
    }

    public Attendance() {
    }

    public Attendance(Student student, Laboratory laboratory) {
        this.student = student;
        this.laboratory = laboratory;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }
}
