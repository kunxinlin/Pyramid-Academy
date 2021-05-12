package com.example.demo.entity;
import javax.persistence.*;

//Employee Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "employee") //This is for the actual name of the database table we are mapping to the class.
public class Employee {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "date") //This will map the firstName field to the column named job_title in the table.
    private String date;

    @Column(name = "first_name") //This will map the firstName field to the column named first_name in the table.
    private String firstName;

    @Column(name = "last_name") //This will map the lastName field to the column named last_name in the table.
    private String lastName;

    @Column(name = "email") //This will map the email field to the column named email in the table.
    private String email;

    @Column(name = "password") //This will map the password field to the column named password in the table.
    private String password;

    @Column(name = "phone_number") //This will map the Phone Number field to the column named Phone Number in the table.
    private String phoneNumber;

    @Column(name = "age") //This will map the Phone Number field to the column named Phone Number in the table.
    private int age;

    @Column(name = "gender") //This will map the Gender field to the column named Gender in the table.
    private String gender;

    @Column(name = "administrator") //This will map the Administrator field to the column named Administrator in the table.
    private boolean administrator;

    //default constructor
    public Employee() {
    }

    //para constructor
    public Employee(String date, String firstName, String lastName, String email, String password, String phoneNumber, int age, String gender, boolean administrator) {
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password =password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
        this.administrator = administrator;
    }

    //getter/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    //ToString Method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", Administrator='" + administrator + '\'' +
                '}';
    }

}
