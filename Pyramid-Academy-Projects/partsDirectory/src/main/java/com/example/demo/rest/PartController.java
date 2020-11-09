package com.example.demo.rest;


import com.example.demo.dao.PartDAO;
import com.example.demo.dao.PartDAOInterface;
import com.example.demo.entity.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class PartController {

    private final PartDAO partDAO;

    //Constructor Injection: this is telling the spring framework to wire up your dependencies.
    @Autowired
    public PartController(PartDAO partDAO) {
        this.partDAO = partDAO;
    }
    
    //http://localhost:8080/retrieveAllParts
    @GetMapping("/retrieveAllParts")
    public List<Part> findAll() {
        return partDAO.findAll();
    }

    //http://localhost:8080/getPart/1
    @GetMapping("/getPart/{partId}")
    public Part findById(@PathVariable int partId){
        return partDAO.findById(partId);
    }

    //http://localhost:8080/addPart
    @PostMapping("/addPart")
    public Part addPart(@RequestBody Part part) {
        //also just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .... instead of update
        part.setId(0);
        partDAO.save(part);
        return part;
    }

    //http://localhost:8080/updatePart
    @PutMapping("/updatePart")
    public Part updatePart(@RequestBody Part part) {
        //No thePart.setId(0); this will execute an update instead of a create
        partDAO.save(part);
        return part;
    }

    //http://localhost:8080/deletePart/1
    @DeleteMapping("/deletePart/{partId}")
    public String deletePart(@PathVariable int partId) {

        Part tempPart = partDAO.findById(partId);

        if(tempPart == null) {
            throw new RuntimeException("Part is not found : " + partId);
        }

        partDAO.deleteById(partId);
        return "Deleted employee id : " + partId;
    }

}
