package ru.itis.javalab.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM \"user\" WHERE id = ?";
    //language=SQL
    private static final String SQL_FIND_ALL = "SELECT * FROM \"user\"";
    //language=SQL
    private static final String SQL_FIND_ALL_WITH_PAGES = "SELECT * FROM \"user\" ORDER BY id LIMIT :limit OFFSET :offset";
    //language=SQL
    private static final String SQL_FIND_BY_UUID = "SELECT * FROM \"user\" WHERE uuid = ?";
    //language=SQL
    private static final String SQL_FIND_BY_LOGIN = "SELECT * FROM \"user\" WHERE login = :login";


    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .firstName(row.getString("firstname"))
            .lastName(row.getString("lastname"))
            .age(row.getInt("age"))
            .login(row.getString("login"))
            .hashPassword(row.getString("hashpassword"))
            .uuid(row.getString("uuid"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
    }

    @Override
    public List<User> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_WITH_PAGES, params, userRowMapper);
    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User entity) {
        Map<String, Object> keys = new SimpleJdbcInsert(this.jdbcTemplate)
                .withTableName("\"user\"")
                .usingColumns("firstname", "lastname", "age", "login", "hashpassword", "uuid")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKeyHolder(Map.of(
                        "firstname", entity.getFirstName(),
                        "lastname", entity.getLastName(),
                        "age", entity.getAge(),
                        "login", entity.getLogin(),
                        "hashpassword", passwordEncoder.encode(entity.getHashPassword()),
                        "uuid", UUID.randomUUID().toString()
                ))
                .getKeys();
        entity.setId((Long) keys.get("id"));
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }


    @Override
    public boolean containsUser(String login, String password) {
        List<User> users = namedParameterJdbcTemplate.query(SQL_FIND_BY_LOGIN, Map.of("login", login), userRowMapper);
        return passwordEncoder.matches(password, users.get(0).getHashPassword());
    }

    @Override
    public Long getUserId(String login, String password) {
        return null;
    }

    @Override
    public boolean containsLogin(String login) {
        return false;
    }

    @Override
    public List<User> findByUuid(String uuid) {
        return jdbcTemplate.query(SQL_FIND_BY_UUID, userRowMapper, uuid);
    }

    @Override
    public List<User> findByData(String login) {
        return jdbcTemplate.query(SQL_FIND_BY_LOGIN, userRowMapper, login);
    }

}
