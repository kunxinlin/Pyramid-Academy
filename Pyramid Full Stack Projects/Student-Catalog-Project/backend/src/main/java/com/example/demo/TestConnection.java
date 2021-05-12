package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {
        //The code below is to check to make sure you have a database connection with MySQL
        String jdbcUrl = "jdbc:mysql://localhost:3306/full_stack_student_catalog?useSSL=false&serverTimezone=UTC";
        String user = "studentcatalog";
        String password = "studentcatalog"; // You can change the password to check to see if it throws an exception.
        try{
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful!!!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}