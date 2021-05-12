package com.example.demo.rest;

import com.example.demo.dao.UserLoginDAO;
import com.example.demo.dao.UserLoginDAOImpl;
import com.example.demo.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class LoginController {

    private final UserLoginDAOImpl loginDAO;

    @Autowired
    public LoginController(UserLoginDAOImpl loginDAO) {
        this.loginDAO = loginDAO;
    }

    //http://localhost:8080/getAllUsers
    @GetMapping("/getAllUsers")
    public List<UserLogin> findAll(){
        return loginDAO.findAll();
    }

    @GetMapping("/getUser/{id}")
    public UserLogin findById(@PathVariable int id){
        return loginDAO.findById(id);
    }

    @GetMapping("/getPassword/{email}")
    public String getPassword(@PathVariable("email") String email){
        UserLogin user = loginDAO.findLoginByEmail(email);

        if(user == null){
            throw new RuntimeException("Email is not found: " + email);
        }

        return user.getPassword();
    }

    @GetMapping("/professor/{email}")
    public boolean isProfessor(@PathVariable("email") String email) {
        UserLogin user = loginDAO.findLoginByEmail(email);

        if(user == null){
            throw new RuntimeException("User is not found: " + email);
        }

        return user.isProfessor();

    }

    @PostMapping("/addUser")
    public UserLogin addUser(@RequestBody UserLogin user){
        user.setId(0); //incase a id is passed in
        loginDAO.save(user);
        return user;
    }

    @PutMapping("/updateUser")
    public UserLogin updateUserLogin(@RequestBody UserLogin user){
        loginDAO.save(user);
        return user;
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        UserLogin user = loginDAO.findById(id);

        if(user == null){
            throw new RuntimeException("User does not exist with id: " + id);
        }

        loginDAO.deleteById(id);
        return "Deleted user with id: " + id;
    }

}