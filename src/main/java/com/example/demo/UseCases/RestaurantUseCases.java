package com.example.demo.UseCases;

<<<<<<< HEAD
import com.example.demo.Domini.Restaurant;
import com.example.demo.Persistence.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("restaurantUseCases")
public class RestaurantUseCases {

    @Autowired
    private RestaurantDAO restDAO;

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

    public List<Restaurant> findByPuntuacio(int puntuacio) {
        return restDAO.findByPuntuacio(puntuacio);
    }

=======
import com.example.demo.Persistence.RestaurantDAO;

public class RestaurantUseCases {

    private RestaurantDAO restDAO;

    public void insertRestaurant(){

    }
>>>>>>> 9b865464573bae6fd5f83d214b39a2846bd4c03f
}
