package com.junho.junblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.junho.junblog.model.User;

//자동으로 bean 등록이 된다
//@Respository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User>findByUsername(String username);
	

}



//User findByUsernameAndPassword(String username,String password);
//@Query(value="SELECT * FROM user WHERE username = ?1 AND password =?2",nativeQuery = true)
//User login(String username,String password);