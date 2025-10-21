package io.resousadev.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.resousadev.domain.Course;

@RequestMapping("/courses")
public class CourseController {

    private final List<Course> courses = new ArrayList<>();

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        if (course.getTitle() == null || course.getTitle().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        courses.add(course);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/courses/example")
    public ResponseEntity<Course> getExampleCourse() {
        Course example = Course.builder()
                .title("Spring Boot Fundamentals")
                .description("Curso completo de Spring Boot com exemplos práticos")
                .workload(40)
                .build();
        
        return ResponseEntity.ok(example);
    }
}
