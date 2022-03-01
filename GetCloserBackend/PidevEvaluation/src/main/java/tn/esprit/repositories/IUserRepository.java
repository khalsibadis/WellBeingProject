package tn.esprit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.User;
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

}
