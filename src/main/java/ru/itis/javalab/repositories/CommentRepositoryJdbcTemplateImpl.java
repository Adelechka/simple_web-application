package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ru.itis.javalab.models.Comment;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommentRepositoryJdbcTemplateImpl implements CommentRepository {

    //language=SQL
    private static final String GET_ALL_COMMENTS = "SELECT * FROM comment";
    //language=SQL
    private static final String SAVE_COMMENT = "INSERT INTO comment (author, text) VALUES (:author, :text)";
    //language=SQL
    private static final String SQL_FIND_ALL_WITH_PAGES = "SELECT * FROM comment ORDER BY id LIMIT :limit OFFSET :offset";

    private RowMapper<Comment> commentRowMapper = (row, i) -> Comment.builder()
            .id(row.getInt("id"))
            .author(row.getString("author"))
            .text(row.getString("text"))
            .build();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CommentRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Comment> findAll() {
        return jdbcTemplate.query(GET_ALL_COMMENTS, commentRowMapper);
    }

    @Override
    public List<Comment> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_WITH_PAGES, params, commentRowMapper);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Comment entity) {
        Map<String, Object> keys = new SimpleJdbcInsert(this.jdbcTemplate)
                .withTableName("comment")
                .usingColumns("author", "text")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKeyHolder(Map.of(
                        "author", entity.getAuthor(),
                        "text", entity.getText())
                ).getKeys();
        entity.setId((Integer) keys.get("id"));

//        Map<String, Object> params = new HashMap<>();
//        params.put("author", entity.getAuthor());
//        params.put("text", entity.getText());
//        namedParameterJdbcTemplate.query(SAVE_COMMENT, params, commentRowMapper);
    }

    @Override
    public void update(Comment entity) {

    }

    @Override
    public void delete(Comment entity) {

    }
}
