package com.yeahbutstill.repository;

import com.yeahbutstill.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
            insert into course(id, name, author) values(?, ?, ?);
            """;

    private static final String DELETEDYID_QUERY = """
            delete from course where id = ?
            """;

    private static final String SELECT_QUERY = """
            select * from course where id = ?
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(DELETEDYID_QUERY, id);
    }

    public Course findById(Long id) {
        // ResultSet -> Bean => Row Mapper => id
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
