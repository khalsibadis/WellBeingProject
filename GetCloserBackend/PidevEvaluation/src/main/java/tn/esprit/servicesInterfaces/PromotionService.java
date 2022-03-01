package tn.esprit.servicesInterfaces;

import java.util.List;

import tn.esprit.entities.Promotion;

public interface PromotionService {

	Promotion AddPromotion(Promotion p);
	public void  addAndaffectPromotion(Promotion p, Long IdUser);
	Promotion updatePromotion (Promotion p);
	void DeletePromotion (Long id);
	List<Promotion> retrieveAllPromotions();
	Promotion retrievePromotion (Long id);
	
}
