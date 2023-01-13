package com.yeahbutstill.commandlinerunner;

import com.yeahbutstill.entity.Course;
import com.yeahbutstill.repository.CourseSpringDataJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

    private final CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Autowired
    public CourseSpringDataJpaCommandLineRunner(CourseSpringDataJpaRepository courseSpringDataJpaRepository) {
        this.courseSpringDataJpaRepository = courseSpringDataJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // INSERT
        courseSpringDataJpaRepository.save(new Course(11L, "Learn AWS 11", "Winda"));
        courseSpringDataJpaRepository.save(new Course(12L, "Learn Docker 12", "Winda"));
        courseSpringDataJpaRepository.save(new Course(13L, "Learn Vault 13", "Winda"));
        courseSpringDataJpaRepository.save(new Course(14L, "Learn Keycloak 14", "Winda"));
        courseSpringDataJpaRepository.save(new Course(15L, "Learn OAuth2 15", "Winda"));
        courseSpringDataJpaRepository.save(new Course(1999L, "STAN 16661", "Luchifer 16661"));

        // DELETE
        courseSpringDataJpaRepository.deleteById(1999L);

        // SELECT
        log.info("courseSpringDataJpaRepository.findById() = " + courseSpringDataJpaRepository.findById(11L));
        log.info("courseSpringDataJpaRepository.findByAuthor() = " + courseSpringDataJpaRepository.findByAuthor("Maya"));
        log.info("courseSpringDataJpaRepository.count() = " + courseSpringDataJpaRepository.count());
        log.info("courseSpringDataJpaRepository.findAll() = " + courseSpringDataJpaRepository.findAll());
        log.info("courseSpringDataJpaRepository.findByName(\"Learn Vault 13\") = " + courseSpringDataJpaRepository.findByName("Learn Vault 13"));
    }

}
