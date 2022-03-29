package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Opinion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeEmotions typeEmotions;
    private String description;
    private boolean IsBlocked;;
    private Date date;
    @ManyToOne
    private User user;
}
