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


        Usuari aux = new Usuari.UsuariBuilder().userName("Prova").password("password").punts(0).reserves_no_presentades(0).build();
        usuUseCases.insert(aux);

        System.out.println("Usuari Creat i inserit");

        System.out.println("AQUI TENS TOTS EL USUARIS: ");
        usuUseCases.findAll().forEach(System.out::println);



        Reserva var = new Reserva.ReservaBuilder().usuari("Prova").data_reserva("12/10/2019").comensals(8).presentat(1).id_reserva(89).build();


        rsvUseCases.insert(var);

        System.out.println("Reserva creada i inserida");


        System.out.println("AQUI TENS TOTES LES RESERVES: ");

        rsvUseCases.findAll().forEach(System.out::println); //Falta fer un tostring en reserves



        Restaurant rest = new Restaurant.RestaurantBuilder().nomRestaurant("Rest1").direccio("C/Mossen Jaume Urgell").poblacio("Parets").puntuacio(10).descripcio("Molt bo").numTelefon(935621020).build();


        restUseCases.insert(rest);
        System.out.println("RESTAURANT INSERIT");


        System.out.println("AQUI TENS TOTS ELS RESTAURANTS:");
        restUseCases.findAll().forEach(System.out::println);

    }
}
