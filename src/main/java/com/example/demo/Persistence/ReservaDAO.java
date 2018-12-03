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
	 private final String INSERT = "insert into Reserva (id_reserva, username, restaurant,data_reserva, comensals, presentat, torn) values(?,?,?, ?, ?, ?, ?)";
	 private final String SELECT_BY_ID = "SELECT * FROM Reserva WHERE id_reserva= ?";
	 private final String UPDATE = "UPDATE Reserva SET data_reserva= ,comensals= ,presentat= ,  WHERE id_reserva= ";
	 private final String SELECT_BY_REST = "SELECT * FROM Reserva WHERE restaurant= ?";

	 private final String GET_Comensals = "SELECT * from Reserva where restaurant= ? AND data_reserva= ? AND torn= ?";

	 private final RowMapper<Reserva> mapper = (resultSet, i) -> {
	        return new Reserva(
	        		resultSet.getInt("id_reserva"),
					resultSet.getString("userName"),
					resultSet.getString("restaurant"),
	                resultSet.getString("data_reserva"),
	                resultSet.getInt("comensals"),
					resultSet.getInt("presentat"),
					resultSet.getInt("torn"));
	 };


	public  ReservaDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Reserva> findAll() {
		//instead of using the rowMapper it uses the BeanPropertyRowMapper to fo it authomatically
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Reserva.class));
	}

	public int insert(Reserva reserva) {
		reserva.generarId();
		return jdbcTemplate.update(INSERT,reserva.getId_reserva(),reserva.getUserName(),reserva.getRestaurant(),reserva.getData_reserva(), reserva.getComensals(),
				reserva.getPresentat(),reserva.getTorn());
	}


	public int update(Reserva reserva){
		return jdbcTemplate.update(UPDATE,reserva.getId_reserva(),reserva.getData_reserva(),reserva.getComensals(),reserva.getPresentat(),reserva.getId_reserva(),reserva.getTorn());
	}

	public Reserva findById(int id){
		Reserva a= jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id} , mapper);
		return a;
	}

	public List<Reserva> findByRest(String rest) {
		//instead of using the rowMapper it uses the BeanPropertyRowMapper to fo it authomatically
		return jdbcTemplate.query(SELECT_BY_REST, new Object[]{rest}, mapper);
	}
	public List<Reserva> capacitatReservada(String nom,int torn,String data){
		return jdbcTemplate.query(GET_Comensals,new Object[]{nom,data,torn},mapper);
	}


}
