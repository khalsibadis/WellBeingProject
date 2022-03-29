package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeAnswer typeAnswer;
    private boolean ResponseUser;
    @ManyToOne
    private Question question;
    @ManyToMany
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeAnswer getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(TypeAnswer typeAnswer) {
        this.typeAnswer = typeAnswer;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
