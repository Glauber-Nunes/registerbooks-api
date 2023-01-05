package com.glauber.registerbooksapi.exceptionsResource;

import lombok.Data;

import java.time.Instant;

@Data
public class ErroPadrao {

    private Instant timestamp;
    private int status;
    private String Error;
    private String messenger;
    private String path;

    public ErroPadrao(Instant timestamp, int status, String Error, String messenger, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.Error = Error;
        this.messenger = messenger;
        this.path = path;
    }

    public ErroPadrao(){

    }
}
