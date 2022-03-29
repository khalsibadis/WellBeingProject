package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypePub typePub;
    private String Statut;
    private boolean IsBlocked;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "publication",cascade = CascadeType.ALL)
    private Set<CommentPub> commentPub;
    @ManyToMany
    private Set<LikePub> likePubs;
}
