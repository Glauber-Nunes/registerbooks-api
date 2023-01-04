package com.glauber.registerbooksapi.confiPerfil;

import com.glauber.registerbooksapi.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class PerfilDev {

    @Autowired
    private DataService dataService;

    @Bean
    public void instanciaData(){
        dataService.instanciaData();

    }
}
