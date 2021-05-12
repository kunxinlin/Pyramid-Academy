package com.example.demo.rest;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.StudentDAOImpl;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class StudentController {

    private final StudentDAOImpl studentDAOImpl;

    @Autowired
    public StudentController(StudentDAOImpl studentDAOImpl) {this.studentDAOImpl = studentDAOImpl;}

    //http://localhost:8080/getAllStudents
    @GetMapping("/getAllStudents")
    public List<Student> findAll() {
        return studentDAOImpl.findAll();
    }


    //http://localhost:8080/addStudent
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student theStudent) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        theStudent.setId(0);

        studentDAOImpl.save(theStudent);
        return theStudent;
    }

    //http://localhost:8080/updateStudent
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student updateStudent) {
        //No theEmployee.setId(0); this will execute an update instead of a create
        studentDAOImpl.save(updateStudent);
        return updateStudent;
    }

    //http://localhost:8080/studentEmployee/1
    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        //Creating a tempEmployee to check to see if an employee exists
        Student tempStudent = studentDAOImpl.findById(studentId);

        //This will throw an exception if the employee is null
        if(tempStudent == null) {
            throw new RuntimeException("Student is not found : " + studentId);
        }

        //This will execute the deleteByID method in the employeeDaoImpl.
        studentDAOImpl.deleteById(studentId);
        return "Deleted student id : " + studentId;
    }
}
