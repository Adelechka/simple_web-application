package ru.itis.javalab.repositories;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.models.Client;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientsRepositoryJdbcImpl implements ClientsRepository {

        //language=SQL
        private static final String SQL_FIND_ALL = "SELECT * FROM client";
        //language=SQL
        private static final String SQL_FIND_BY_ID = "SELECT * FROM client WHERE id = ?";
        //language=SQL
        private static final String SQL_FIND_BY_LOGIN = "SELECT * FROM client WHERE login = ?";
        //language=SQL
        private static final String SQL_FIND_BY_UUID = "SELECT * FROM client WHERE uuid = ?";
        //language=SQL
        private static final String SQL_SAVE_CLIENT = "INSERT INTO client (login, password, uuid) VALUES (?, ?, ?)";

    private DataSource dataSource;

    private SimpleJdbcTemplate template;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ClientsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    private RowMapper<Client> clientRowMapper = row -> Client.builder()
            .id(row.getLong("id"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .Uuid(row.getString("uuid"))
            .build();

    @Override
    public List<Client> findAll() {
        return template.query(SQL_FIND_ALL, clientRowMapper);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Client entity) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SAVE_CLIENT);

            statement.setString(1, entity.getLogin());
            statement.setString(2, passwordEncoder.encode(entity.getPassword()));
            statement.setString(3, entity.getUuid());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    // ignore
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    // ignore
                }
            }
        }

       // template.execute(SQL_SAVE_CLIENT, entity.getLogin(), entity.getPassword());
    }

    @Override
    public void update(Client entity) {

    }

    @Override
    public void delete(Client entity) {

    }


    @Override
    public List<Client> findByUuid(String uuid) {
        return template.query(SQL_FIND_BY_UUID, clientRowMapper, uuid);
    }

    @Override
    public List<Client> findByData(String login) {
        return template.query(SQL_FIND_BY_LOGIN, clientRowMapper, login);
    }
}
