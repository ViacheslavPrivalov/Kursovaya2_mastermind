package com.example.kursovaya2_mastermind.service;

import com.example.kursovaya2_mastermind.exceptions.AmountVeryBigException;
import com.example.kursovaya2_mastermind.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerJavaService implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerJavaService(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount > questionService.getAll().size()) {
            throw new AmountVeryBigException();
        }

        Set<Question> questionSet = new HashSet<>(amount);
        for (int i = 0; i < amount; i++) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return Collections.unmodifiableSet(questionSet);
    }
}
