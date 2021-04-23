package com.example.assignment_2.data.model;

import javax.persistence.Entity;

@Entity
public class StudentDB extends UserDB {
    private boolean registered;
    private String fullName;
    private String groupID;
    private String hobby;

    public StudentDB() {
    }

    public StudentDB(String email, String password, boolean registered, String fullName, String groupID, String hobby) {
        super(email, password);
        this.registered = registered;
        this.fullName = fullName;
        this.groupID = groupID;
        this.hobby = hobby;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}