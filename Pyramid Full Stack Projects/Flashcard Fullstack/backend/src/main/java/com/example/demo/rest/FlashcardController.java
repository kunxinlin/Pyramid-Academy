package com.example.demo.rest;

import com.example.demo.dao.FlashcardDAO;
import com.example.demo.dao.UserLoginDAO;
import com.example.demo.dao.UserLoginDAOImpl;
import com.example.demo.entity.Flashcard;
import com.example.demo.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class FlashcardController {

    private final FlashcardDAO flashcardDAO;

    @Autowired
    public FlashcardController(FlashcardDAO flashcardDAO) {
        this.flashcardDAO = flashcardDAO;
    }

    //http://localhost:8080/getAllUsers
    @GetMapping("/getAllCards")
    public List<Flashcard> findAll(){
        return flashcardDAO.findAll();
    }

    @GetMapping("/getRandomCard")
    public Flashcard getRandom(){
        return flashcardDAO.retrieveRandom();
    }

    @PostMapping("/addCard")
    public Flashcard addCard(@RequestBody Flashcard card){
        card.setId(0); //incase a id is passed in
        flashcardDAO.save(card);
        return card;
    }

    @PutMapping("/updateCard")
    public Flashcard updateCard(@RequestBody Flashcard card){
        flashcardDAO.save(card);
        return card;
    }

    @DeleteMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable int id){
        Flashcard card = flashcardDAO.findById(id);

        if(card == null){
            throw new RuntimeException("Card does not exist with id: " + id);
        }

        flashcardDAO.deleteById(id);
        return "Deleted card with id: " + id;
    }

}