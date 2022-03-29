package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class LikePub implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Enumerated(EnumType.STRING)
    private EnumLike enumLike;
    @ManyToMany(mappedBy = "likePubs")
    private Set<Publication> publications;
    @OneToOne
    private  User users;
}
