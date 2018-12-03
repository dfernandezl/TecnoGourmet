package com.example.demo.Persistence;


import com.example.demo.Domini.Restaurant;
import com.example.demo.Domini.Usuari;
import com.example.demo.LogIn.LogIn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.text.DecimalFormat;
import java.util.List;

@Repository
public class RestaurantDAO {

    private JdbcTemplate jdbcTemplate;

    private final String INSERT = "insert into Restaurant (nom, password, direccio, poblacio, puntuacio, descripcio, telefon, capacitat, foto, nVots) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String FIND_ALL = "select * from Restaurant order by puntuacio DESC";
    private final String FIND_BY_RESTAURANT_NAME = "select * from Restaurant where nom = ?";
    private final String FIND_BY_POBLACIO = "select * from Restaurant where poblacio = ?";
    private final String FIND_BY_PUNTUACIO = "select * from Restaurant where puntuacio >= ? order by puntuacio";



    private final String UPDATE = "update Restaurant set puntuacio = ?, nVots= ? where nom= ?";

    private static DecimalFormat df2 = new DecimalFormat(".##");

    private final RowMapper<Restaurant> mapper = (resultSet, i) -> {
        return  new Restaurant(
                resultSet.getString("nom"),
                resultSet.getString("password"),
                resultSet.getString("direccio"),
                resultSet.getString("poblacio"),
                resultSet.getDouble("puntuacio"),
                resultSet.getString("descripcio"),
                resultSet.getInt("telefon"),
                resultSet.getInt("capacitat"),
                resultSet.getString("foto"),
                resultSet.getInt("nVots")
               );
    };


    public  RestaurantDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Restaurant> findAll() {
        //instead of using the rowMapper it uses the BeanPropertyRowMapper to fo it authomatically
        return jdbcTemplate.query(FIND_ALL, mapper);
    }


    public int insert(Restaurant restaurant) {

        return jdbcTemplate.update(INSERT, restaurant.getNomRestaurant(), restaurant.getPassword(), restaurant.getDireccio(), restaurant.getPoblacio(),
                0,restaurant.getDescripcio(),restaurant.getNumTelefon(), restaurant.getCapacitat(), restaurant.getFoto(),0);
    }

    public int update(Restaurant restaurant){
        return jdbcTemplate.update(UPDATE,restaurant.getNomRestaurant(), restaurant.getPassword(),restaurant.getDireccio(), restaurant.getPoblacio(),
                restaurant.getPuntuacio(),restaurant.getDescripcio(),restaurant.getNumTelefon(), restaurant.getCapacitat());
    }

    public List<Restaurant> findByPoblacio(String poblacio) {
        //instead of using the rowMapper it uses the BeanPropertyRowMapper to fo it authomatically
        return jdbcTemplate.query(FIND_BY_POBLACIO, new Object[]{poblacio},mapper);
    }

    public Restaurant findByName(String nom) {
        return jdbcTemplate.queryForObject(FIND_BY_RESTAURANT_NAME, new Object[]{nom},mapper);
    }

    public List<Restaurant> findByPuntuacio(double puntuacio) {
        //instead of using the rowMapper it uses the BeanPropertyRowMapper to fo it authomatically
        return jdbcTemplate.query(FIND_BY_PUNTUACIO, new Object[]{puntuacio},mapper);
    }


    public int puntua(String nom, int puntuacio){

        Restaurant aux=findByName(nom);
        double mitjana=Math.floor(((aux.puntuacio*aux.nVots)+puntuacio)/(aux.nVots+1)*100)/100;

        return jdbcTemplate.update(UPDATE,mitjana,aux.nVots+1,nom);
    }
    public Restaurant validateRestaurant(LogIn logIn){

        String sql = "select * from Restaurant where nom='" + logIn.getUsername() + "' and password='" + logIn.getPassword() + "'";

        List<Restaurant> restaurants = jdbcTemplate.query(sql, mapper);
        return restaurants.size() > 0 ? restaurants.get(0) : null;
    }

}
