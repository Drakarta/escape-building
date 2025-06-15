package org.example.tests.mocks;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.questions.QuestionsList;

import java.util.List;

public class QuestionsListMock extends QuestionsList {
    public boolean getRandomQuestionCalled = false;
    public String lastSortRequested;

    private QuestionsForm fixedQuestion;

    public QuestionsListMock() {
        fixedQuestion = new QuestionsForm("testSort","openQuestion","Mock question?",new java.util.ArrayList<>(List.of("Mock answer")),new java.util.ArrayList<>());
    }

    @Override
    public QuestionsForm getRandomQuestionWithQuestionSort(String questionSort) {
        getRandomQuestionCalled = true;
        lastSortRequested = questionSort;
        return fixedQuestion;
    }
}
