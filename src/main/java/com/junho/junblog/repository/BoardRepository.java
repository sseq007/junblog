package com.junho.junblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junho.junblog.model.Board;

//자동으로 bean 등록이 된다
//@Respository 생략 가능
public interface BoardRepository extends JpaRepository<Board, Integer> {


}



//User findByUsernameAndPassword(String username,String password);
//@Query(value="SELECT * FROM user WHERE username = ?1 AND password =?2",nativeQuery = true)
//User login(String username,String password);