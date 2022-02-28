package com.WellBeingProject.GetCloser.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Opinion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypeEmotions typeEmotions;
    private String description;
    private boolean Visibility;
    private Date date;
    @ManyToOne
    private Account account;
}
