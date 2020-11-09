package com.example.demo.dao;

//Get a list of all the parts in the database.
//Get a single part by ID.
//Add a new part.
//Update an existing part.
//Delete an existing part.

import com.example.demo.entity.Part;
import java.util.List;

public interface PartDAOInterface {
    List<Part> findAll();
    Part findById(int id);
    void save(Part part);
    void deleteById(int id);
}
