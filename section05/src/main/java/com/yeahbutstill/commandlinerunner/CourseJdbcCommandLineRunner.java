package com.yeahbutstill.commandlinerunner;

import com.yeahbutstill.entity.Course;
import com.yeahbutstill.repository.CourseJdbcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository courseJdbcRepository;

    @Autowired
    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // INSERT
        courseJdbcRepository.insert(new Course(1L, "Learn AWS", "Yeah But Still"));
        courseJdbcRepository.insert(new Course(2L, "Learn Docker", "Yeah But Still"));
        courseJdbcRepository.insert(new Course(3L, "Learn Vault", "Yeah But Still"));
        courseJdbcRepository.insert(new Course(4L, "Learn Keycloak", "Yeah But Still"));
        courseJdbcRepository.insert(new Course(5L, "Learn OAuth2", "Yeah But Still"));
        courseJdbcRepository.insert(new Course(666L, "STAN", "Luchifer"));

        // DELETE
        courseJdbcRepository.deleteById(666L);

        // SELECT
        log.info("courseJdbcRepository.findById() = " + courseJdbcRepository.findById(1L));
        log.info("courseJdbcRepository.findById() = " + courseJdbcRepository.findById(5L));
    }

}
