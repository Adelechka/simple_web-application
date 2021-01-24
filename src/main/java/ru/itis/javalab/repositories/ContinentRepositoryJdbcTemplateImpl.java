package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.Comment;
import ru.itis.javalab.models.Continent;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ContinentRepositoryJdbcTemplateImpl implements ContinentRepository {

    //language=SQL
    private static final String GET_ALL_CONTINENTS = "SELECT * FROM continent";

    private RowMapper<Continent> continentRowMapper = (row, i) -> Continent.builder()
            .id(row.getInt("id"))
            .name(row.getString("name"))
            .build();

    private JdbcTemplate jdbcTemplate;

    public ContinentRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Continent> findAll() {
        return jdbcTemplate.query(GET_ALL_CONTINENTS, continentRowMapper);
    }

    @Override
    public List<Continent> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Continent> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Continent entity) {

    }

    @Override
    public void update(Continent entity) {

    }

    @Override
    public void delete(Continent entity) {

    }
}
