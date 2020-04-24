package com.example.demo.rest;

import com.example.demo.pojo.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class PersonController {
    ArrayList<Person> myFamily = new ArrayList<>();

    @GetMapping("/person")
    public ArrayList<Person> person() {
        return myFamily;
    }

    @PostMapping("/person")
    public void createMyFamily(@RequestBody Person person) {
        myFamily.add(person);
    }

    @PutMapping("/person/{index}")
    public String updateMyFamily(@PathVariable int index) {
        myFamily.get(index).setFirstName("Jack");
        myFamily.get(index).setLastName("Killer");
        return "Updated";
    }

    @DeleteMapping("/person/{index}")
    public String deleteFamilyMember(@PathVariable int index) {
        myFamily.remove(index);
        return "Deleted Family Member at index: " + index;
    }
}
