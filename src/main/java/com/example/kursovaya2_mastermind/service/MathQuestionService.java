package com.example.kursovaya2_mastermind.service;

import com.example.kursovaya2_mastermind.model.Question;
import com.example.kursovaya2_mastermind.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository repository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {

        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<String> questionList = List.of(
                "MathQuestion1",
                "MathQuestion2",
                "MathQuestion3",
                "MathQuestion4"
        );
        List<String> answerList = List.of(
                "MathAnswer1",
                "MathAnswer2",
                "MathAnswer3",
                "MathAnswer4"
        );
        Question question = new Question(questionList.get(random.nextInt(questionList.size())),
                answerList.get(random.nextInt(answerList.size())));
        return question;
    }
}
