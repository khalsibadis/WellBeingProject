package com.WellBeingProject.GetCloser.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypeAnswer typeAnswer;
    private String answer;
    private boolean ResponseUser;
    @ManyToOne
    private Question question;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeAnswer getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(TypeAnswer typeAnswer) {
        this.typeAnswer = typeAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isResponseUser() {
        return ResponseUser;
    }

    public void setResponseUser(boolean responseUser) {
        ResponseUser = responseUser;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
