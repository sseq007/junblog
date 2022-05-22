package com.junho.junblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junho.junblog.model.RoleType;
import com.junho.junblog.model.User;
import com.junho.junblog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired//외존성 주입(DI)
	private UserRepository userRepository;
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username : "+user.getUsername());
		System.out.println("password : "+user.getPassword());
		System.out.println("email : "+user.getEmail());
		user.setRole(RoleType.USER);
		userRepository.save(user);
		
		return "회원가입이 완료되었습니다";
		
	}
}
