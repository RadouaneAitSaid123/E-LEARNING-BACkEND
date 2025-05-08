package com.emsi.e_learning_backend.mapper;

import com.emsi.e_learning_backend.dto.ChoiceDTO;
import com.emsi.e_learning_backend.dto.ContentSectionDTO;
import com.emsi.e_learning_backend.dto.CourseDTO;
import com.emsi.e_learning_backend.dto.QuizQuestionDTO;
import com.emsi.e_learning_backend.model.Choice;
import com.emsi.e_learning_backend.model.ContentSection;
import com.emsi.e_learning_backend.model.Course;
import com.emsi.e_learning_backend.model.QuizQuestion;

import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseDTO toDTO(Course course) {
        if (course == null) return null;

        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setPrice(course.getPrice());
        dto.setImageUrl(course.getImageUrl());

        dto.setContentSections(course.getContentSections().stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList()));

        dto.setQuizQuestions(course.getQuiz().stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    public static Course toEntity(CourseDTO dto) {
        if (dto == null) return null;

        Course course = new Course();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setPrice(dto.getPrice());
        course.setImageUrl(dto.getImageUrl());

        course.setContentSections(dto.getContentSections().stream()
                .map(CourseMapper::toEntity)
                .collect(Collectors.toList()));

        course.setQuiz(dto.getQuizQuestions().stream()
                .map(CourseMapper::toEntity)
                .collect(Collectors.toList()));

        return course;
    }

    private static ContentSectionDTO toDTO(ContentSection section) {
        ContentSectionDTO dto = new ContentSectionDTO();
        dto.setHeading(section.getTitle());
        dto.setBody(section.getContent());
        return dto;
    }

    private static ContentSection toEntity(ContentSectionDTO dto) {
        ContentSection section = new ContentSection();
        section.setTitle(dto.getHeading());
        section.setContent(dto.getBody());
        return section;
    }

    private static QuizQuestionDTO toDTO(QuizQuestion question) {
        QuizQuestionDTO dto = new QuizQuestionDTO();
        dto.setQuestionText(question.getQuestionText());

        dto.setChoices(question.getChoices().stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    private static QuizQuestion toEntity(QuizQuestionDTO dto) {
        QuizQuestion question = new QuizQuestion();
        question.setQuestionText(dto.getQuestionText());

        question.setChoices(dto.getChoices().stream()
                .map(CourseMapper::toEntity)
                .collect(Collectors.toList()));

        return question;
    }

    private static ChoiceDTO toDTO(Choice choice) {
        ChoiceDTO dto = new ChoiceDTO();
        dto.setText(choice.getText());
        dto.setCorrect(choice.isCorrect());
        return dto;
    }

    private static Choice toEntity(ChoiceDTO dto) {
        Choice choice = new Choice();
        choice.setText(dto.getText());
        choice.setCorrect(dto.isCorrect());
        return choice;
    }
}
