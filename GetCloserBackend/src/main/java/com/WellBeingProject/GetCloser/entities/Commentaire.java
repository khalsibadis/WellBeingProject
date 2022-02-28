package com.example.EventManage.entities;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Event event;

    @ManyToOne
    private User user;
}
