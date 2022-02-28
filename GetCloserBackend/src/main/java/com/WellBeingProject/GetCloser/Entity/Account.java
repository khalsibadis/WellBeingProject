package com.WellBeingProject.GetCloser.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean notification;
    private int member;
    @OneToMany(mappedBy = "account")
    private Set <Opinion> opinion;
    @OneToMany(mappedBy = "account")
    private Set<QVT>qvts;
    @OneToMany(mappedBy ="account" )
    private Set<Publication>publications;


}
