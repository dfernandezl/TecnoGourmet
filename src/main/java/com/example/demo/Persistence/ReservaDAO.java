package com.example.demo.Persistence;

import com.example.demo.Domini.Usuari;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Domini.Reserva;

import java.util.List;

@Repository
public class ReservaDAO {
	 private JdbcTemplate jdbcTemplate;
	 
	 private final String FIND_ALL = "select * from Reserva";
	 private final String INSERT = "insert into Reserva ( id_reserva, username, data_reserva, comensals, presentat) values(?, ?, ?, ?, ?)";

	 private final String UPDATE = "UPDATE Reserva SET data_reserva= ,comensals= ,presentat= ,  WHERE id_reserva= ";


	 private final RowMapper<Reserva> mapper = (resultSet, i) -> {
	        return new Reserva.ReservaBuilder()
					.usuari(resultSet.getString("userName"))
					.id_reserva(resultSet.getInt("id_reserva"))
	                .data_reserva(resultSet.getString("data_reserva"))
	                .comensals(resultSet.getInt("comensals"))
	                .presentat(resultSet.getInt("presentat"))
	                .build();
	 };


	public  ReservaDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Reserva> findAll() {
		//instead of using the rowMapper it uses the BeanPropertyRowMapper to fo it authomatically
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Reserva.class));
	}

	public int insert(Reserva reserva) {
		return jdbcTemplate.update(INSERT, reserva.getId_reserva(), reserva.getUserName(), reserva.getData_reserva(), reserva.getComensals(),
				reserva.isPresentat());
	}


	public int update(Reserva reserva){
		return jdbcTemplate.update(UPDATE,reserva.getData_reserva(),reserva.getComensals(),reserva.isPresentat(),reserva.getId_reserva());
	}




}
