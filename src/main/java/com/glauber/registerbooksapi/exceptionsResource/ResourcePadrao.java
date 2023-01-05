package com.glauber.registerbooksapi.exceptionsResource;

import com.glauber.registerbooksapi.service.excptions.EntityNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourcePadrao {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<ErroPadrao> categoriaNotFoundResource(EntityNotFound e, HttpServletRequest request){

        ErroPadrao erro = new ErroPadrao();

        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("RECURSO NAO ENCONTRADO");
        erro.setMessenger(e.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
