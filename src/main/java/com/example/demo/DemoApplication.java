package com.example.demo;

import com.example.demo.Domini.Usuari;
import com.example.demo.UseCases.UsuariUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UsuariUseCases usuUseCases;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {


        System.out.println("HOLAAAA");
        Usuari aux = new Usuari.UsuariBuilder().userName("Prova").password("password").punts(0).reserves_no_presentades(0).build();
        System.out.println("HOLAAAA2");
        usuUseCases.insert(aux);
        System.out.println("HOLAAAA");
        usuUseCases.findAll().forEach(System.out::println);

    }
}
