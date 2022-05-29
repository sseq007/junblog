package com.junho.junblog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.junho.junblog.dto.ResponseDto;

@ControllerAdvice //모든 @Controller 즉, 전역에서 발생할 수 있는 예외를 잡아 처리해주는 annotation
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseDto<String> handleArgumentException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
		
	}
}
