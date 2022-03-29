package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class CommentPub implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String description;
    private boolean IsBlocked;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publication publication;
    @ManyToOne
    private User user;

}
