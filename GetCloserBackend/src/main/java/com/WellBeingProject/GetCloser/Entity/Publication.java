package com.WellBeingProject.GetCloser.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypePub typePub;
    private boolean Recommander;
    private String Statut;
    @ManyToOne
    private Account account;
    @OneToMany(mappedBy = "publication")
    private Set<CommentPub> commentPub;

}
