package com.junho.junblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junho.junblog.config.auth.PrincipalDetail;
import com.junho.junblog.dto.ReplySaveRequestDto;
import com.junho.junblog.dto.ResponseDto;
import com.junho.junblog.model.Board;
import com.junho.junblog.model.Reply;
import com.junho.junblog.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardService.글쓰기(board,principal.getUser());

		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		
		boardService.글삭제하기(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody  Board board){
		boardService.글수정하기(id,board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
	
		
		boardService.댓글쓰기(replySaveRequestDto);

		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user,HttpSession session){
//		System.out.println("UserApiController : login 호출됨");
//		User principal= userService.로그인(user);
//		if(principal !=null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
	
}
