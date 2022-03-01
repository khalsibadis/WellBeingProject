package tn.esprit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Promotion;
@Repository
public interface IPromotionRepository extends CrudRepository<Promotion, Long> {

}
