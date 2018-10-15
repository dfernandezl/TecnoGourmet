package com.example.demo.Persistence;

import org.springframework.jdbc.core.JdbcTemplate;

public class RestaurantDAO {

    private JdbcTemplate jdbcTemplate;

    private final String INSERT_RESTAURANT = "insert into Restaurant (nomRestaurant, direccio, poblacio, puntuacio, descripcio, numTelefon) values(?, ?, ?, ?, ?, ?)";
    private final String FIND_ALL = "select * from Resturant";
    private final String FIND_BY_RESTAURANT_NAME = "select * from Restaurant where nomRestaurant = ?";
    private final String FIND_BY_POBLACIO = "select * from Restaurant where poblacio = ?";
    private final String FIND_BY_PUNTUACIO = "select * from Restaurant where puntuacio = ?";
    private final String UPDATE_RESTAURANT = "update Restaurant set nomRestaurant = ?, direccio = ?, poblacio = ?, puntuacio = ?, numTelefon = ?";


}
