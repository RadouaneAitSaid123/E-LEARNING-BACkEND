package com.emsi.e_learning_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    private List<ContentSectionDTO> contentSections;
    private List<QuizQuestionDTO> quizQuestions;

}
