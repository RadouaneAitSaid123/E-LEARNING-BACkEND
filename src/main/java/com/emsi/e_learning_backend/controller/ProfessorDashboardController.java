package com.emsi.e_learning_backend.controller;

import com.emsi.e_learning_backend.model.Course;
import com.emsi.e_learning_backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class ProfessorDashboardController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public Map<String, Object> getProfessorStats(@RequestParam Long professorId) {
        List<Course> courses = courseRepository.findByProfessorId(professorId);
        Map<Long, Integer> enrollments = new HashMap<>();
        Map<Long, Double> completionRates = new HashMap<>();
        Map<Long, String> courseNames = new HashMap<>();
        int totalStudents = 0;

        for (Course course : courses) {
            enrollments.put(course.getId(), course.getEnrolledCount());
            courseNames.put(course.getId(), course.getTitle());
            completionRates.put(course.getId(), Math.random()); // mock data for completion %
            totalStudents += course.getEnrolledCount();
        }

        Map<String, Object> statusBreakdown = Map.of(
                "completed", totalStudents / 3,
                "inProgress", totalStudents / 3,
                "notStarted", totalStudents / 3
        );

        return Map.of(
                "courseNames", courseNames,
                "totalCourses", courses.size(),
                "totalStudents", totalStudents,
                "enrollmentsPerCourse", enrollments,
                "completionRates", completionRates,
                "statusBreakdown", statusBreakdown
        );
    }
}
