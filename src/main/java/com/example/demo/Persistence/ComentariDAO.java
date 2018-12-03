package com.example.demo.Persistence;

import com.example.demo.Domini.Comentari;
import com.example.demo.Domini.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentariDAO {

    private JdbcTemplate jdbcTemplate;

    private final String INSERT="INSERT INTO Comentari(id_comentari,userName,restaurant,text) values (?,?,?,?)";
    private final String SELECT_BY_ID="SELECT * FROM Comentari where restaurant= ?";

    private final RowMapper<Comentari> mapper = (resultSet, i) -> {
        return new Comentari(
                resultSet.getInt("id_comentari"),
                resultSet.getString("userName"),
                resultSet.getString("restaurant"),
                resultSet.getString("text"));
    };



    public  ComentariDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(Comentari comentari) {
        return jdbcTemplate.update(INSERT,comentari.generarID(),comentari.getUsuari(),comentari.getRestaurant(),comentari.getText());
    }

    public List<Comentari> findByRestaurant(String nomRestarurant){
        return jdbcTemplate.query(SELECT_BY_ID, new Object[]{nomRestarurant} , mapper);
    }

}
