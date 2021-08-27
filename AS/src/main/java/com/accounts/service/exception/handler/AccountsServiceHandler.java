package com.accounts.service.exception.handler;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.accounts.service.dto.ResponseDto;

@ControllerAdvice
public class AccountsServiceHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDto> handleException(ApplicationException e, WebRequest request) {

		return new ResponseEntity<>(new ResponseDto(e.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
