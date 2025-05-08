package com.emsi.e_learning_backend.controller;

import com.emsi.e_learning_backend.model.Course;
import com.emsi.e_learning_backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class ProfessorCourseController {

    @Autowired
    private CourseRepository courseRepository;

    // GET all courses for professor
    @GetMapping
    public List<Course> getCourses(@RequestParam Long professorId) {
        return courseRepository.findByProfessorId(professorId);
    }

    // GET single course
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    // POST create new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // PUT update course
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        Course course = courseRepository.findById(id).orElseThrow();
        updatedCourse.setId(id);
        return courseRepository.save(updatedCourse);
    }

    // DELETE course
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}
