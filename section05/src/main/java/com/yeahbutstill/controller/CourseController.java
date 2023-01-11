package com.yeahbutstill.controller;

import com.yeahbutstill.entity.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(
                new Course(1L, "Learn AWS", "Yeah But Still"),
                new Course(2L, "Learn DevOps", "Yeah But Still"),
                new Course(3L, "Learn Postgres", "Yeah But Still"),
                new Course(4L, "Learn Linux RHELL", "Yeah But Still"),
                new Course(5L, "Learn Unit Test", "Yeah But Still")
        );
    }

}
