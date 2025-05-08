package com.emsi.e_learning_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizQuestionDTO {
    private String questionText;
    private List<ChoiceDTO> choices;

}
