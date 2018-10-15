package com.example.demo.Persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Domini.Reserva;

@Repository
public class ReservaDAO {
	 private JdbcTemplate jdbcTemplate;
	 
	 private final String FIND_ALL = "select * from reserves";
	 private final RowMapper<Reserva> mapper = (resultSet, i) -> {
	        return new Reserva.ClassroomBuilder()
	                .capacity(resultSet.getInt("capacity"))
	                .name(resultSet.getString("name"))
	                .orientation(resultSet.getString("orientation"))
	                .plugs(resultSet.getBoolean("plugs"))
	                .build();
	    };
}
