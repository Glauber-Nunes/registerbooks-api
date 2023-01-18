package com.glauber.registerbooksapi.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.glauber.registerbooksapi.service.excptions.EntityNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandller {

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<StandardError> entityNotFoundResource(EntityNotFound e, HttpServletRequest request) {

		StandardError erro = new StandardError();

		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setError("RECURSO NAO ENCONTRADO");
		erro.setMessenger(e.getMessage());
		erro.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(com.glauber.registerbooksapi.service.excptions.DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(
			com.glauber.registerbooksapi.service.excptions.DataIntegrityViolationException e,
			HttpServletRequest request) {

		StandardError erro = new StandardError();

		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setError("ERRO DataIntegrityViolationException");
		erro.setMessenger(e.getMessage());
		erro.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationErros(MethodArgumentNotValidException m,
			HttpServletRequest request) {

		ValidationError erro = new ValidationError();

		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setError("ERROR MethodArgumentNotValidException");
		erro.setMessenger("Erro Na Validaçao Dos Campos");
		erro.setPath(request.getRequestURI());

		for (FieldError f : m.getBindingResult().getFieldErrors()) {
			erro.addErros(f.getField(), f.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

}
