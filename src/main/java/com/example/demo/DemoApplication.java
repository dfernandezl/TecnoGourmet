package com.example.demo;

import com.example.demo.Domini.Reserva;
import com.example.demo.Domini.Restaurant;
import com.example.demo.Domini.Usuari;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UsuariUseCases usuUseCases;

    @Autowired
    private ReservaUseCases rsvUseCases;


    @Autowired
    private RestaurantUseCases restUseCases;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
    	//una prova simplement

        Usuari aux = new Usuari.UsuariBuilder().userName("Prova").password("password").build();
        Usuari aux2 = new Usuari.UsuariBuilder().userName("Prova2").password("password").build();

        usuUseCases.insert(aux);
        usuUseCases.insert(aux2);

        System.out.println("Usuari Creat i inserit");

        System.out.println("AQUI TENS TOTS EL USUARIS: ");
        usuUseCases.findAll().forEach(System.out::println);


        Reserva var = new Reserva.ReservaBuilder().usuari("Prova").data_reserva("12/10/2019").comensals(8).build();
        //Reserva var2 = new Reserva.ReservaBuilder().usuari("Prova2").data_reserva("12/10/2019").comensals(8).build();


        rsvUseCases.insert(var);

        //rsvUseCases.insert(var2);

        System.out.println("Reserves creades i inserides");


        System.out.println("AQUI TENS TOTES LES RESERVES: ");

        rsvUseCases.findAll().forEach(System.out::println);


/*
        Restaurant rest = new Restaurant.RestaurantBuilder().nomRestaurant("Rest1").direccio("C/Mossen Jaume Urgell").poblacio("Parets").puntuacio(10).descripcio("Molt bo").numTelefon(935621020).build();

        Restaurant rest2 = new Restaurant.RestaurantBuilder().nomRestaurant("Rest2").direccio("C/Mossen Jaume Urgell").poblacio("Mollet").puntuacio(5).descripcio("Molt bo").numTelefon(935621020).build();


        restUseCases.insert(rest);
        restUseCases.insert(rest2);
        System.out.println("RESTAURANTS INSERITS");


        System.out.println("AQUI TENS TOTS ELS RESTAURANTS:");
        restUseCases.findAll().forEach(System.out::println);
*/
    }



}
