package com.example.demo.rest;

import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class UserController {

    private final UserDAOImpl userDAOImpl;

    @Autowired
    public UserController(UserDAOImpl userDAOImpl) {this.userDAOImpl = userDAOImpl;}

    //http://localhost:8080/getAllUsers
    @GetMapping("/getAllUsers")
    public List<User> findAll() {
        return userDAOImpl.findAll();
    }


    //http://localhost:8080/addUser
    @PostMapping("/addUser")
    public User addUser(@RequestBody User theUser) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        theUser.setId(0);

        userDAOImpl.save(theUser);
        return theUser;
    }

    //http://localhost:8080/updateUser
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User updateUser) {
        //No .setId(0); this will execute an update instead of a create
        userDAOImpl.save(updateUser);
        return updateUser;
    }

    //http://localhost:8080/deleteUser/1
    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId) {

        //Creating a tempEmployee to check to see if an employee exists
        User tempUser = userDAOImpl.findById(userId);

        //This will throw an exception if the employee is null
        if(tempUser == null) {
            throw new RuntimeException("User is not found : " + userId);
        }

        //This will execute the deleteByID method in the employeeDaoImpl.
        userDAOImpl.deleteById(userId);
        return "Deleted user id : " + userId;
    }


}