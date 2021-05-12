package com.example.demo.dao;

import com.example.demo.entity.Flashcard;

import java.util.List;

public interface FlashcardDAO {
    List<Flashcard> findAll();
    Flashcard findById(int id);
    Flashcard retrieveRandom();
    void save(Flashcard flashcard);
    void deleteById(int id);
}
