package com.bolivar.comunes.numeros.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumeroAPalabrasConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.bolivar.comunes.numeros.consumingwebservice.wsdl");
        return marshaller;
    }


    @Bean
    public NumeroAPalabrasService NumeroAPalabrasService (Jaxb2Marshaller marshaller) {
        NumeroAPalabrasService client = new NumeroAPalabrasService();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
