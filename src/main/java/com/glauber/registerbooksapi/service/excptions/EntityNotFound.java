package com.glauber.registerbooksapi.service.excptions;

public class EntityNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNotFound(String msg) {
		super(msg);
	}

}
