package tn.esprit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Promotion;
import tn.esprit.entities.User;
import tn.esprit.repositories.IPromotionRepository;
import tn.esprit.repositories.IUserRepository;
import tn.esprit.servicesInterfaces.PromotionService;
@Service
public class PromotionImpl implements PromotionService{
@Autowired
IUserRepository userRepo ;
@Autowired 
IPromotionRepository promotionrepo ;
	@Override
	public Promotion AddPromotion(Promotion p) {
		
		return promotionrepo.save(p);
	}

	@Override
	public void addAndaffectPromotion(Promotion promotion, Long IdUser) {
		User user = userRepo.findById(IdUser).orElse(null);
		promotion.setUserPromotions(user);
		promotionrepo.save(promotion);
		
	
	}

	@Override
	public Promotion updatePromotion(Promotion p) {
		
		return promotionrepo.save(p);
	}

	@Override
	public void DeletePromotion(Long id) {
		promotionrepo.deleteById(id);
		
	}

	@Override
	public List<Promotion> retrieveAllPromotions() {
		List<Promotion> promotions = (List<Promotion>) promotionrepo.findAll();
		return promotions;
	}

	@Override
	public Promotion retrievePromotion(Long id) {
		Promotion p = promotionrepo.findById(id).orElse(null);
		return p;
	}

}
