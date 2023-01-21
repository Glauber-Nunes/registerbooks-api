package com.glauber.registerbooksapi.resources.exceptions;

public class FieldUnique extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FieldUnique() {
		super();

	}

	public FieldUnique(String message) {
		super(message);

	}

}
