package com.example.demo.entity;

import javax.persistence.*;
import java.sql.*;


@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "userID")
    private int userID;

    public Transaction(){

    }

    public Transaction(String des, Date date, double amount, int userID){
        this.description = des;
        this.date = date;
        this.amount = amount;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", description= \"" + description + '\"' +
                ", date= \"" + date + '\"' +
                ", amount= \"" + amount + '\"' +
                ", userID= \"" + userID + '\"' +
                '}';

    }
}
