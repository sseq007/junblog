package com.junho.junblog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junho.junblog.model.RoleType;
import com.junho.junblog.model.User;
import com.junho.junblog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);

	}
	
	
	
//	@Transactional(readOnly = true)
//	public User 로그인(User user) {
//			return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//
//	}

}
