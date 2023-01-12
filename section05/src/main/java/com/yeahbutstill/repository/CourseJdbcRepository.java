package com.yeahbutstill.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_QUERY = """
        insert into course(id, name, author) values(1, 'Learn AWS', 'Yeahbutstill');
        insert into course(id, name, author) values(2, 'Learn Docker', 'Yeahbutstill');
        insert into course(id, name, author) values(3, 'Learn Vault', 'Yeahbutstill');
        insert into course(id, name, author) values(4, 'Learn Key Cloak', 'Yeahbutstill');
        insert into course(id, name, author) values(5, 'Learn OAuth2', 'Yeahbutstill');
    """;

    public void insert() {
        jdbcTemplate.update(INSERT_QUERY);
    }

}
