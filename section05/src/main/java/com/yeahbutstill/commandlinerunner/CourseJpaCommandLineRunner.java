package com.yeahbutstill.commandlinerunner;

import com.yeahbutstill.entity.Course;
import com.yeahbutstill.repository.CourseJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    private final CourseJpaRepository courseJpaRepository;

    @Autowired
    public CourseJpaCommandLineRunner(CourseJpaRepository courseJpaRepository) {
        this.courseJpaRepository = courseJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // INSERT
        courseJpaRepository.insert(new Course(6L, "Learn AWS 6", "Maya"));
        courseJpaRepository.insert(new Course(7L, "Learn Docker 7", "Maya"));
        courseJpaRepository.insert(new Course(8L, "Learn Vault 8", "Maya"));
        courseJpaRepository.insert(new Course(9L, "Learn Keycloak 9", "Maya"));
        courseJpaRepository.insert(new Course(10L, "Learn OAuth2 10", "Maya"));
        courseJpaRepository.insert(new Course(999L, "STAN 666", "Luchifer 666"));

        // DELETE
        courseJpaRepository.deleteById(999L);

        // SELECT
        log.info("courseJpaRepository.findById() = " + courseJpaRepository.findById(6L));
        log.info("courseJpaRepository.findById() = " + courseJpaRepository.findById(7L));
    }

}
