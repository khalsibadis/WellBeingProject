package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name) ;
}
