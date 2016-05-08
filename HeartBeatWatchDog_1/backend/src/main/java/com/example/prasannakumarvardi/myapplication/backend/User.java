package com.example.prasannakumarvardi.myapplication.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prasannakumarvardi on 5/1/16.
 */

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class User /*extends Person*/{

    @Id
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Person> emergencyContact;

    /*public User(){
        super();
    }*/

    public User(String name, String email, String phoneNumber){
        //super(name,email,phoneNumber);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        emergencyContact = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(List<Person> emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
