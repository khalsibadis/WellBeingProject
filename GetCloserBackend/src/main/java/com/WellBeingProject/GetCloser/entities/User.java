package com.example.EventManage.entities;

import com.example.EventManage.enumeration.Departement;
import com.example.EventManage.enumeration.Office;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Transactional
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String picture;
    @Enumerated(EnumType.STRING)
    private Departement departement;
    @Enumerated(EnumType.STRING)
    private Office office;


    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<Event> events;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;
}
