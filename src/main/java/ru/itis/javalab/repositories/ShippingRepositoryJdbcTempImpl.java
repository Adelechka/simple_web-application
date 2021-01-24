package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.javalab.models.Comment;
import ru.itis.javalab.models.Shipping;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ShippingRepositoryJdbcTempImpl implements ShippingRepository {

    //language=SQL
    private static final String GET_ALL_SHIPPING = "SELECT * FROM shipping";

    private RowMapper<Shipping> shippingRowMapper = (row, i) -> Shipping.builder()
            .id(row.getInt("id"))
            .name(row.getString("name"))
            .build();

    private JdbcTemplate jdbcTemplate;

    public ShippingRepositoryJdbcTempImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Shipping> findAll() {
        return jdbcTemplate.query(GET_ALL_SHIPPING, shippingRowMapper);
    }

    @Override
    public List<Shipping> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Shipping> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Shipping entity) {

    }

    @Override
    public void update(Shipping entity) {

    }

    @Override
    public void delete(Shipping entity) {

    }
}
