package com.example.demo.Persistence;

import com.example.demo.Domini.Usuari;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsuariDAO {


    private JdbcTemplate jdbcTemplate;
    private final String FIND_ALL ="SELECT * FROM Usuari";
    private final String INSERT = "insert into Usuari (username, password, punts, reserves_no_presentades) values(?, ?, ?, ?)";
    private final String UPDATE_PASSWORD = "UPDATE Usuari SET password=  WHERE name= ";


    private final RowMapper<Usuari> mapper = (resultSet, i) -> {
        return new Usuari.UsuariBuilder()
                .userName(resultSet.getString("userName"))
                .password(resultSet.getString("password"))
                .punts(resultSet.getInt("punts"))
                .reserves_no_presentades(resultSet.getInt("reserves_no_presentades"))
                .build();
    };


    public  UsuariDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Usuari> findAll() {
        //instead of using the rowMapper it uses the BeanPropertyRowMapper to fo it authomatically
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Usuari.class));
    }


    public int insert(Usuari usuari) {
        return jdbcTemplate.update(INSERT, usuari.getUserName(), usuari.getPassword(), usuari.punts(),
                usuari.getReserves_no_presentades());
    }

    public int updatePassword(Usuari usuari){
        return jdbcTemplate.update(UPDATE_PASSWORD,usuari.getPassword(),usuari.getUserName());
    }











}
