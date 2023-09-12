package com.bookshelf.finder.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookshelf.finder.entity.UserEntity;
import com.bookshelf.finder.repository.UserRepository;

@Service
public class UserService {
	Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	 UserRepository userRepository;

	public void registerUser(String name, String userId, String email, String password,String confirmPassword) {

		UserEntity userEntity=new UserEntity();
		userEntity.setName(name);
		userEntity.setUserId(userId);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setConfirmPassword(confirmPassword);
	    logger.info("saved a user in mysql db sucessfully");
		userRepository.save(userEntity);
	}
	 
}
