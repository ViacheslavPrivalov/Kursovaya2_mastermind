package com.example.kursovaya2_mastermind.service;

import com.example.kursovaya2_mastermind.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
