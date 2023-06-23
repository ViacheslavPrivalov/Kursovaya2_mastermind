package com.example.kursovaya2_mastermind.repository;

import com.example.kursovaya2_mastermind.exceptions.MethodNotUsedException;
import com.example.kursovaya2_mastermind.exceptions.NoSuchQuestionException;
import com.example.kursovaya2_mastermind.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;

@Repository
public class MathQuestionRepository implements QuestionRepository {
//    private final Set<Question> questions = new HashSet<>();
//
//    @PostConstruct
//    public void init() {
//        Question q1 = new Question("MathQuestion1", "MathAnswer1");
//        Question q2 = new Question("MathQuestion2", "MathAnswer2");
//        Question q3 = new Question("MathQuestion3", "MathAnswer3");
//        Question q4 = new Question("MathQuestion4", "MathAnswer4");
//        questions.add(q1);
//        questions.add(q2);
//        questions.add(q3);
//        questions.add(q4);
//    }
    @Override
    public Question add(String question, String answer) {

        throw new MethodNotUsedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotUsedException();
    }

    @Override
    public Question remove(Question question) {

        throw new MethodNotUsedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotUsedException();
    }
}
