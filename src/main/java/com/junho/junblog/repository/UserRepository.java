package com.junho.junblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junho.junblog.model.User;

//자동으로 bean 등록이 된다
//@Respository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
