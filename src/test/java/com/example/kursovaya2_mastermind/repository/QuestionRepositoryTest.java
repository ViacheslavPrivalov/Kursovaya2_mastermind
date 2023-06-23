package com.example.kursovaya2_mastermind.repository;

import com.example.kursovaya2_mastermind.exceptions.MethodNotUsedException;
import com.example.kursovaya2_mastermind.exceptions.NoSuchQuestionException;
import com.example.kursovaya2_mastermind.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionRepositoryTest {
    private final QuestionRepository outJava = new JavaQuestionRepository();
    private final QuestionRepository outMath = new MathQuestionRepository();

    public static Stream<Arguments> paramsForAddMethod() {
        return Stream.of(
                Arguments.of("question?", "answer!"),
                Arguments.of("q", "a"),
                Arguments.of(" ", " ")
        );
    }

    private static Collection<Question> questions = Set.of(
            new Question("question", "answer"),
            new Question("Question", "Answer"),
            new Question("Quest", "Ans")
    );

    @BeforeEach
    public void init() {
        outJava.add(new Question("question", "answer"));
        outJava.add(new Question("Question", "Answer"));
        outJava.add(new Question("Quest", "Ans"));
    }

    @ParameterizedTest
    @MethodSource("paramsForAddMethod")
    public void addMethodTesting(String question, String answer) {
        Question actual = new Question(question, answer);
        Question expectedJava = outJava.add(question, answer);

        assertEquals(actual, expectedJava);

        assertTrue(outJava.getAll().contains(actual));
    }

    @Test
    public void shouldReturnQuestion() {
        Question q = new Question("question1", "answer1");

        assertEquals(q, outJava.add(q));
        assertEquals(outJava.getAll().size(), 4);
        assertTrue(outJava.getAll().contains(q));

        assertEquals(q, outJava.remove(q));
        assertEquals(outJava.getAll().size(), 3);
        assertFalse(outJava.getAll().contains(q));

    }

    @Test
    public void shouldReturnCollection() {
        assertEquals(questions, outJava.getAll());
        assertEquals(questions.size(), outJava.getAll().size());

    }

    @Test
    public void shouldThrowException() {
        assertThrows(NoSuchQuestionException.class,
                () -> outJava.remove(new Question("question2", "answer2")));

        assertThrows(MethodNotUsedException.class,
                () -> outMath.add(new Question("question2", "answer2")));
        assertThrows(MethodNotUsedException.class,
                () -> outMath.remove(new Question("question2", "answer2")));
        assertThrows(MethodNotUsedException.class,
                () -> outMath.getAll());
    }
}
