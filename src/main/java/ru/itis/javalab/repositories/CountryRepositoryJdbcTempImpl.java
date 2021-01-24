package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.Comment;
import ru.itis.javalab.models.Continent;
import ru.itis.javalab.models.Country;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CountryRepositoryJdbcTempImpl implements CountryRepository {

    //language=SQL
    private static final String GET_ALL_COUNTRIES = "SELECT * FROM country JOIN continent c on c.id = country.continent_id ORDER BY country.name;";
    //language=SQL
    private static final String GET_ALL_COUNTRIES_BY_ID = "SELECT * FROM country JOIN continent c on c.id = country.continent_id WHERE c.id = :id ORDER BY country.name;";

    private RowMapper<Country> countryRowMapper = (row, i) -> Country.builder()
            .id(row.getInt("id"))
            .name(row.getString(3))
            .continent(Continent.builder()
                    .name(row.getString(6))
                    .build())
            .description(row.getString("description"))
            .build();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CountryRepositoryJdbcTempImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query(GET_ALL_COUNTRIES, countryRowMapper);
    }

    @Override
    public List<Country> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Country entity) {

    }

    @Override
    public void update(Country entity) {

    }

    @Override
    public void delete(Country entity) {

    }

    @Override
    public List<Country> findAllById(int id) {
        Map<String, Object> params = new HashMap();
        params.put("id", id);
        return namedParameterJdbcTemplate.query(GET_ALL_COUNTRIES_BY_ID, params, countryRowMapper);
    }
}
