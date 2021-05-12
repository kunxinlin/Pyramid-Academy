package com.example.demo.entity;
import javax.persistence.*;

@Entity
@Table(name = "flashcard")
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    public Flashcard(){

    }

    public Flashcard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", question= \"" + question + '\"' +
                ", answer= \"" + answer + '\"' +
                '}';

    }
}
