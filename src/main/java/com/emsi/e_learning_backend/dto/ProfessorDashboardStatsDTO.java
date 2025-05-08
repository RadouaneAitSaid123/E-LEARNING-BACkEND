package com.emsi.e_learning_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ProfessorDashboardStatsDTO {
    private int totalCourses;
    private int totalStudents;

    private Map<Long, Integer> enrollmentsPerCourse;     // courseId -> number of enrollments
    private Map<Long, Double> completionRates;           // courseId -> % completed
    private Map<String, Integer> statusBreakdown;        // status -> count (e.g., "completed", "inProgress")

}
