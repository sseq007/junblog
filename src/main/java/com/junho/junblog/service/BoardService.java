package com.junho.junblog.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junho.junblog.dto.ReplySaveRequestDto;
import com.junho.junblog.model.Board;
import com.junho.junblog.model.Reply;
import com.junho.junblog.model.User;
import com.junho.junblog.repository.BoardRepository;
import com.junho.junblog.repository.ReplyRepository;
import com.junho.junblog.repository.UserRepository;

@Service
public class BoardService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Transactional
	public void 글쓰기(Board board,User user) {

		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);

	}
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록 (Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패:아이디를 찾을 수 없습니다");
				});
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
				
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패:아이디를 찾을 수 없습니다");
				});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}
	
	@Transactional
	public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
	
		Board board = boardRepository.findById(replySaveRequestDto.getBoardId()).orElseThrow(()->{
			return new IllegalArgumentException("댓글쓰기 실패: 게시글 id를 찾을수 없습니다");
		});
		User user = userRepository.findById(replySaveRequestDto.getUserId()).orElseThrow(()->{
			return new IllegalArgumentException("댓글쓰기 실패: 게시글 id를 찾을수 없습니다");
		});
		
		Reply reply =Reply.builder()
				.user(user)
				.board(board)
				.content(replySaveRequestDto.getContent())
				.build();
		
		replyRepository.save(reply);
	}
	


}


	
//	@Transactional(readOnly = true)
//	public User 로그인(User user) {
//			return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//
//	}


