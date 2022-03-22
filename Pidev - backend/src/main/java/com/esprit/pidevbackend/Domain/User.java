package com.esprit.pidevbackend.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String name ;
    String username ;
    String password ;
    String picture ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    Collection<Role> roles = new ArrayList<>();




}
