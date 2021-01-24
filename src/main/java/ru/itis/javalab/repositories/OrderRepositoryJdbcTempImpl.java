package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ru.itis.javalab.dto.OrderDto;
import ru.itis.javalab.models.Country;
import ru.itis.javalab.models.Order;
import ru.itis.javalab.models.Shipping;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.*;

public class OrderRepositoryJdbcTempImpl implements OrderRepository {

    //language=SQL
    private static final String TOUR_CREATE = "INSERT INTO tour_order (tourism_user_id, country_id, hotel_stars, shipping_id, preferences) values (:tourism_user_id, :country_id, :hotel_stars, :shipping_id, :preferences)";
    //language=SQL
    private static final String GET_ALL_ORDER = "SELECT u.login, c.name, hotel_stars, s.name, preferences, paid FROM tour_order " +
            "JOIN country c on c.id = tour_order.country_id " +
            "JOIN shipping s on s.id = tour_order.shipping_id " +
            "JOIN \"user\" u on u.id = tour_order.tourism_user_id;";
    //language=SQL

    private RowMapper<Order> orderRowMapper = (row, i) -> Order.builder()
            .user(User.builder()
                    .login(row.getString(1))
                    .build())
            .country(Country.builder()
                    .name(row.getString(2))
                    .build())
            .star(row.getInt(3))
            .shipping(Shipping.builder()
                    .name(row.getString(4))
                    .build())
            .preferences(row.getString(5))
            .build();


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    public OrderRepositoryJdbcTempImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("tour_order");
    }


    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query(GET_ALL_ORDER, orderRowMapper);
    }

    @Override
    public List<Order> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Order entity) {

    }

    @Override
    public void save(OrderDto entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("tourism_user_id", entity.getUserId());
        params.put("country_id", entity.getCountryId());
        params.put("hotel_stars", entity.getHotelStars());
        params.put("shipping_id", entity.getShippingId());
        params.put("preferences", entity.getPreferences());
        namedParameterJdbcTemplate.update(TOUR_CREATE, params);
    }


    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Order entity) {

    }
}
