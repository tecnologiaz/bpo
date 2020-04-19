package com.prueba.gfcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Esta clase contiene el inicio de la aplicaciòn
 * @author German Francisco Cuèllar 
 * @version 1.0
 */


@SpringBootApplication
@EnableJpaAuditing
public class PruebaApplication {
                    
                   /**
                 * Metodo inicial de Spring 
                 * @param args Argumentos tipo String para inicio aplicacion
                 */
    
        
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
}
