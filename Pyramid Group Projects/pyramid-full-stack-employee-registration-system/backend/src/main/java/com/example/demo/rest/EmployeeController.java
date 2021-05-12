package com.example.demo.rest;

import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is to allow calls from React
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class EmployeeController {


    private final EmployeeDaoImpl employeeDaoImpl;

    @Autowired
    public EmployeeController(EmployeeDaoImpl employeeDaoImpl) {
        this.employeeDaoImpl = employeeDaoImpl;
    }

    //http://localhost:8080/retrieveAllEmployees
    @GetMapping("/retrieveAllEmployees")
    public List<Employee> findAll() {
        return employeeDaoImpl.findAll();
    }

    @GetMapping("/employee/{employeeEmail}")
    public Employee findEmployeeByEmail(@PathVariable("employeeEmail") String employeeEmail) {

        Employee employee = employeeDaoImpl.findInfoByEmail(employeeEmail);

        if(employee == null) {
            throw new RuntimeException("Email is not found : " + employeeEmail);
        }

        return employee;
    }

    @GetMapping("/password/{employeeEmail}")
    public String findPasswordByEmail(@PathVariable("employeeEmail") String employeeEmail) {

        Employee employee = employeeDaoImpl.findInfoByEmail(employeeEmail);

        if(employee == null) {
            throw new RuntimeException("Email is not found : " + employeeEmail);
        }

        return employee.getPassword();
    }

    @GetMapping("/admin/{employeeEmail}")
    public boolean isAdmin(@PathVariable("employeeEmail") String employeeEmail) {

        Employee employee = employeeDaoImpl.findInfoByEmail(employeeEmail);

        if(employee == null) {
            throw new RuntimeException("Email is not found : " + employeeEmail);
        }

        return employee.isAdministrator();
    }

    //http://localhost:8080/addEmployee
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        theEmployee.setId(0);

        employeeDaoImpl.save(theEmployee);
        return theEmployee;
    }

    //http://localhost:8080/updateEmployee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee updateEmployee) {
        //No theEmployee.setId(0); this will execute an update instead of a create
        employeeDaoImpl.save(updateEmployee);
        return updateEmployee;
    }

    //http://localhost:8080/deleteEmployee/1
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        //Creating a tempEmployee to check to see if an employee exists
        Employee tempEmployee = employeeDaoImpl.findById(employeeId);

        //This will throw an exception if the employee is null
        if(tempEmployee == null) {
            throw new RuntimeException("Employee is not found : " + employeeId);
        }

        //This will execute the deleteByID method in the employeeDaoImpl.
        employeeDaoImpl.deleteById(employeeId);
        return "Deleted employee id : " + employeeId;
    }
}
