package com.glauber.registerbooksapi.service.excptions;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound(String msg){
        super(msg);
    }


}
