package com.glauber.registerbooksapi.service.excptions;

// EXCESSAO PARA EVITAR QUE NOSSA CATEGORIA SEJA DELETADA SE EXISTIR LIVROS ASSOCIADOS A ELA
public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String message) {
		super(message);

	}

}
