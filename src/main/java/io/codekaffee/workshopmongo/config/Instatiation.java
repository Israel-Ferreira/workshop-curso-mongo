package io.codekaffee.workshopmongo.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instatiation implements CommandLineRunner{



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Servidor Iniciado");
    }
    
}
