package com.example.demo.rest;

import com.example.demo.pojo.Hello;
import com.example.demo.pojo.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HelloWorldRestController {
    Hello hi = new Hello("Hello World");

    @GetMapping("/")
    public String defaultController(){
        return "Default";
    }

    @GetMapping("/home")
    public String home(){
        return "Home";
    }

    @GetMapping("/hello")
    public String helloController() {
        return hi.getHello();
    }

    @PutMapping("/hello")
    public String updateHello(){
        hi.setHello("Hello Kris");
        return "Updated Hello";
    }

}
