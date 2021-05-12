package com.example.demo.entity;
import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ssn")
    private int ssn;

    public Student(){

    }

    public Student(String firstName, String lastName, int ssn){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName= \"" + firstName + '\"' +
                ", lastName= \"" + lastName + '\"' +
                ", ssn= \"" + ssn + '\"' +
                '}';

    }
}