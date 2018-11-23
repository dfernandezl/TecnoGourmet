package com.example.demo.Persistence;

import com.example.demo.Domini.Reserva;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaDAO {
	 private JdbcTemplate jdbcTemplate;
	 
	 private final String FIND_ALL = "select * from Reserva";
	 private final String INSERT = "insert into Reserva (id_reserva, username, restaurant,data_reserva, comensals, presentat) values(?,?,?, ?, ?, ?)";
	 private final String SELECT_BY_ID = "SELECT * FROM Reserva WHERE id_reserva= ?";
	 private final String UPDATE = "UPDATE Reserva SET data_reserva= ,comensals= ,presentat= ,  WHERE id_reserva= ";


	 private final RowMapper<Reserva> mapper = (resultSet, i) -> {
	        return new Reserva.ReservaBuilder()
					.usuari(resultSet.getString("userName"))
					.restaurant(resultSet.getString("restaurant"))
	                .data_reserva(resultSet.getString("data_reserva"))
	                .comensals(resultSet.getInt("comensals"))
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
		return jdbcTemplate.update(INSERT,reserva.getId_reserva(),reserva.getUserName(),reserva.getRestaurant(),reserva.getData_reserva(), reserva.getComensals(),
				reserva.getPresentat());
	}


	public int update(Reserva reserva){
		return jdbcTemplate.update(UPDATE,reserva.getId_reserva(),reserva.getData_reserva(),reserva.getComensals(),reserva.getPresentat(),reserva.getId_reserva());
	}

	public Reserva findById(int id){
		return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id} , mapper);
	}




}
