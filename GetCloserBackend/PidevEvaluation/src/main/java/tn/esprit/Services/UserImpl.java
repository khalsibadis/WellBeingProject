package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.User;
import tn.esprit.repositories.IUserRepository;
import tn.esprit.servicesInterfaces.UserService;

@Service
public class UserImpl implements UserService{
	@Autowired
	IUserRepository UserRepo ;

	@Override
	public User AddUser(User u) {
		
		return UserRepo.save(u);
	}

	@Override
	public User UpdateUser(User u) {
		
		return UserRepo.save(u);
	}

}
