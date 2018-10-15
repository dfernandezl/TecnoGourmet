package com.example.demo.Persistence;

import com.example.demo.Domini.Usuari;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UsuariDAO {



    private JdbcTemplate jdbcTemplate;


    private final RowMapper<Usuari> mapper = (resultSet, i) -> {
        return new Usuari.ClassroomBuilder()
                .capacity(resultSet.getInt("capacity"))
                .name(resultSet.getString("name"))
                .orientation(resultSet.getString("orientation"))
                .plugs(resultSet.getBoolean("plugs"))
                .build();
    };






}
