package com.example.demo;

import com.example.demo.Domini.Reserva;
import com.example.demo.Domini.Restaurant;
import com.example.demo.Domini.Usuari;
import com.example.demo.UseCases.ComentariUseCases;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UsuariUseCases usuUseCases;

    @Autowired
    private ReservaUseCases rsvUseCases;


    @Autowired
    private RestaurantUseCases restUseCases;

    @Autowired
    private ComentariUseCases cmtUseCases;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
    	//una prova simplement

        Usuari aux = new Usuari.UsuariBuilder().userName("Filtre").password("password").build();
        Usuari aux2 = new Usuari.UsuariBuilder().userName("Prova2").password("password").build();

        usuUseCases.insert(aux);
        usuUseCases.insert(aux2);

        System.out.println("Usuari Creat i inserit");

        System.out.println("AQUI TENS TOTS EL USUARIS: ");
        usuUseCases.findAll().forEach(System.out::println);


        //Reserva var = new Reserva.ReservaBuilder().usuari("Filtre").data_reserva("12/10/2019").comensals(8).build();
        //Reserva var2 = new Reserva.ReservaBuilder().usuari("Prova2").data_reserva("12/10/2019").comensals(8).build();


        //rsvUseCases.insert(var);

        //rsvUseCases.insert(var2);

        //System.out.println("Reserves creades i inserides");


        //System.out.println("AQUI TENS TOTES LES RESERVES: ");

        //rsvUseCases.findAll().forEach(System.out::println);



        //Restaurant rest = new Restaurant("Rest1","password","C/Mossen Jaume Urgell","Parets",10.0,"Molt bo",935621020,10,"Rest1.png");

        Restaurant rest1 = new Restaurant("Rest1","password","C/Mossen Jaume Urgell","Mollet",10.0,"Molt bo",935621020,10,"/Rest2.jpg",0);
        Restaurant rest2 = new Restaurant("Rest2","password","C/Mossen Jaume Urgell","Granollers",10.0,"Molt bo",935621020,10,"/Rest3.jpg",0);
        Restaurant rest3 = new Restaurant("Rest3","password","C/Mossen Jaume Urgell","Mataró",10.0,"Molt bo",935621020,10,"/Rest4.jpg",0);
        Restaurant rest4 = new Restaurant("Rest4","password","C/Mossen Jaume Urgell","Paris",10.0,"Molt bo",935621020,10,"/Rest5.jpg",0);


        restUseCases.insert(rest1);
        restUseCases.insert(rest2);
        restUseCases.insert(rest3);
        restUseCases.insert(rest4);


        /*
        Reserva var=new Reserva("Rest1","Filtre","2018-01-01",7,0,1);
        rsvUseCases.insert(var);
        */

        //Reserva var2=new Reserva("Rest1","Filtre","2018-01-01",7,0,1);
        //rsvUseCases.insert(var2);

        //List<Reserva> p= rsvUseCases.capacitatReservada(var.getRestaurant(),var.getTorn(),var.getData_reserva());

        //if(p.size()>1){
          //  System.out.println("HOLAA");
        //}



        //Reserva a = rsvUseCases.findById(var.getId_reserva());

        //System.out.println(a);


        /*
        Reserva var2 = new Reserva.ReservaBuilder().usuari("Filtre").restaurant("Rest1").data_reserva("12/12/2019").comensals(8).build();
        rsvUseCases.insert(var2);
        */




    }



}
