package com.example.kursovaya2_mastermind.service;

import com.example.kursovaya2_mastermind.model.Question;
import com.example.kursovaya2_mastermind.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    private final QuestionRepository repositoryMock = mock(QuestionRepository.class);
    private MathQuestionService out;

    private final Question q = new Question("question", "answer");

    @BeforeEach
    public void init() {
        out = new MathQuestionService(repositoryMock);
    }

    @Test
    public void shouldReturnQuestion() {
        assertNotNull(out.getRandomQuestion());
    }
}
