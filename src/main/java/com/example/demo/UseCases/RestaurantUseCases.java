package com.example.demo.UseCases;

import com.example.demo.Domini.Restaurant;
import com.example.demo.Persistence.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("restaurantUseCases")
public class RestaurantUseCases {


    private RestaurantDAO restDAO;

    public RestaurantUseCases(RestaurantDAO restDAO) {
        this.restDAO = restDAO;
    }

    public void insert(Restaurant rest){
        restDAO.insert(rest);
    }

    public List<Restaurant> findAll(){
        return restDAO.findAll();
    }

    public void update(Restaurant rest){
        restDAO.update(rest);
    }

    public List<Restaurant> findByPoblacio(String poblacio){
        return restDAO.findByPoblacio(poblacio);
    }

    public Restaurant findByName(String nom) {
        return restDAO.findByName(nom);
    }

    public List<Restaurant> findByPuntuacio(double puntuacio) {
        return restDAO.findByPuntuacio(puntuacio);
    }


    public void puntuar(String nom, int puntuacio){
        restDAO.puntua(nom,puntuacio);
    }

    public Restaurant getPuntuacio(String nom){
        return restDAO.puntuacioByRest(nom);
    }

}
