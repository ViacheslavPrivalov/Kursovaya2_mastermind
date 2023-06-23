package com.example.kursovaya2_mastermind.controller;

import com.example.kursovaya2_mastermind.model.Question;
import com.example.kursovaya2_mastermind.service.ExaminerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamJavaController {
    private final ExaminerService service;

    public ExamJavaController(@Qualifier("examinerJavaService") ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {

        return service.getQuestions(amount);
    }

}

