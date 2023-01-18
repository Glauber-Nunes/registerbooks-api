package com.glauber.registerbooksapi.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Instant timestamp, int status, String Error, String messenger, String path) {
		super(timestamp, status, Error, messenger, path);
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fielName, String message) {
		this.erros.add(new FieldMessage(fielName, message));
	}

}
