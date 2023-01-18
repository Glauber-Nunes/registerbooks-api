package com.glauber.registerbooksapi.resources.exceptions;

import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class StandardError {

	private Instant timestamp;
	private int status;
	private String Error;
	private String messenger;
	private String path;

	public StandardError() {

	}

	public StandardError(Instant timestamp, int status, String Error, String messenger, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.Error = Error;
		this.messenger = messenger;
		this.path = path;
	}

}
