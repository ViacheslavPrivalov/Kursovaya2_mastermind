package com.example.kursovaya2_mastermind.service;

import com.example.kursovaya2_mastermind.exceptions.AmountVeryBigException;
import com.example.kursovaya2_mastermind.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerMathServiceTest {
    private final MathQuestionService serviceMock = mock(MathQuestionService.class);
    private ExaminerMathService out;

    private final Question randomQuestion = new Question("randomQuestion", "randomAnswer");

    @BeforeEach
    public void init() {
        out = new ExaminerMathService(serviceMock);
        when(serviceMock.getRandomQuestion()).thenReturn(randomQuestion);
    }

    @Test
    public void shouldReturnCollection() {
        Collection<Question> actual = out.getQuestions(1);
        Collection<Question> expected = Set.of(randomQuestion);

        assertNotNull(actual);
        assertEquals(actual, expected);
    }

}
