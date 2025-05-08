package com.emsi.e_learning_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class QuizQuestion {
    @Id
    @GeneratedValue
    private Long id;
    private String questionText;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Choice> choices;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
