package com.example.assignment_2.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class LaboratoryDB {
    private Long id;

    private int number;
    private LocalDate date;
    private String title;
    private String topic;
    private String description;

    public LaboratoryDB() {
    }

    public LaboratoryDB(int number, LocalDate date, String title, String topic, String description) {
        this.number = number;
        this.date = date;
        this.title = title;
        this.topic = topic;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
